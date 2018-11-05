package com.anla.core;

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
            H

        }catch (Throwable cause){

        }finally {
            buf.release();
        }
        return super.decode(ctx, in);
    }
}
