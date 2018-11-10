package com.anla.core;

import com.anla.msg.*;
import com.anla.msg.serializer.BodySerializer;
import com.anla.msg.serializer.TailSerializer;
import com.anla.msg.serializer.factory.SerializerFactory;
import com.anla.msg.util.CommenUtil;
import com.anla.msg.util.HeaderSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-5 下午10:53
 * @description
 */
public class DynamicMsgDecoder extends LengthFieldBasedFrameDecoder {
    private static final Logger LOGGER = LogManager.getLogger(DynamicMsgDecoder.class);

    private static final int MAX_FRAMELENGTH = 4*1024;  //4K
    private static final int LENGTH_FIELD_OFFSET = 0;
    private static final int LENGTH_FILED_LENGTH = 4;
    private static final int LENGTH_ADJUSTMENT = -4;
    private static final int INITIAL_BYTES_TO_STRIP = 0;


    public DynamicMsgDecoder(){
        super(MAX_FRAMELENGTH, LENGTH_FIELD_OFFSET, LENGTH_FILED_LENGTH, LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = null;
        try {
            frame = (ByteBuf) super.decode(ctx, in);
            if (frame == null){
                return null;
            }
            int msgLen = frame.readInt();
            // header
            Header header = HeaderSerializer.getInstance().deserialize(frame);
            // body
            MsgType msgType = header.getType();
            BodySerializer<? extends Body> bodySerializer = getBodySerializer(msgType);
            Body body = bodySerializer.deserializer(frame);

            int headBodyLength = frame.readerIndex();
            // tail
            Tail tail = TailSerializer.getInstance().deserializer(frame);

            if(!checkSum(frame, headBodyLength, tail.getCheckSum())){
                LOGGER.error("checkSum wrong. discard msg. msg type:{}", header.getType());
                return null;
            }

            Message message = Message.createMsgOfDecode(header, body, tail);
            LOGGER.debug("<-- read msgLen:{}, {}", msgLen, message);
            return message;

        }catch (Throwable cause){

        }finally {
            frame.release();
        }
        return super.decode(ctx, in);
    }

    private boolean checkSum(ByteBuf frame, int headBodyLength, int checkSum) {
        int calCheckSum = CommenUtil.checkSum(frame, headBodyLength);
        if(calCheckSum == checkSum){
            return true;
        }else {
            return false;
        }

    }

    private BodySerializer<? extends Body> getBodySerializer(MsgType msgType) {
        return SerializerFactory.getBodySerializer(msgType);
    }
}
