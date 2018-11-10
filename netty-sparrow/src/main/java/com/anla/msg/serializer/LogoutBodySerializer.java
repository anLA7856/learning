package com.anla.msg.serializer;

import com.anla.msg.Body;
import com.anla.msg.body.LogoutBody;
import io.netty.buffer.ByteBuf;

/**
 * @author anLA7856
 * @createTime 18-11-7 下午11:23
 * @description
 */


public class LogoutBodySerializer implements BodySerializer<LogoutBody> {

    private static final LogoutBodySerializer INSTANCE = new LogoutBodySerializer();

    public static LogoutBodySerializer getInstance() {
        return INSTANCE;
    }


    @Override
    public void serializer(ByteBuf out, Body body) {

    }

    @Override
    public LogoutBody deserializer(ByteBuf in) {
        return new LogoutBody();
    }
}