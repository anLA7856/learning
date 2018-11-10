package com.anla.core;

import com.anla.msg.Body;
import com.anla.msg.Header;
import com.anla.msg.Message;
import com.anla.msg.Tail;
import com.anla.msg.serializer.BodySerializer;
import com.anla.msg.serializer.TailSerializer;
import com.anla.msg.serializer.factory.SerializerFactory;
import com.anla.msg.util.CommenUtil;
import com.anla.msg.util.HeaderSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-8 下午11:27
 * @description 编码器
 */
public class DynamicMsgEncoder extends MessageToByteEncoder<Message> {
    private static final Logger LOGGER = LogManager.getLogger(DynamicMsgEncoder.class);
    private final byte[] LENGTH_PLACEHOLDER = new byte[4];

    private long msgNum = 1;

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        if(msg == null || msg.getBody() == null){
            LOGGER.error("Message is null. refuse encode");
            return;
        }
        try {
            // 写入头协议
            fillInHeader(msg);
            // 填写长度占位符
            out.writeBytes(LENGTH_PLACEHOLDER);
            // header
            HeaderSerializer.getInstance().serialize(out, msg.getHeader());
            // body
            BodySerializer<? extends Body> bodySerializer = SerializerFactory.getBodySerializer(msg.getBody().msgType());
            bodySerializer.serializer(out, msg.getBody());
            // 更新header的长度字段
            int msgLen = out.readableBytes() + Tail.byteSize;
            out.setInt(0, msgLen);
            // tail
            TailSerializer.getInstance().serializer(out);
            LOGGER.info("--> encode msgType:{}, msgLen:{}", msg.getHeader().getType(), out.writerIndex());
        } catch (Throwable cause){
            LOGGER.error("Encode error. ", cause);
        }
    }

    private void fillInHeader(Message msg) {
        Header header = msg.getHeader();
        header.setMsgNum(msgNum++);   // 没有担心并发
        header.setType(msg.getBody().msgType());
        header.setMsgTime(CommenUtil.nowTime());
    }
}
