package com.anla.msg.serializer;

import com.anla.msg.Body;
import com.anla.msg.body.LoginRespBody;
import io.netty.buffer.ByteBuf;

/**
 * @author anLA7856
 * @createTime 2018/7/29
 * @description
 */


public final class LoginRespBodySerializer implements BodySerializer<LoginRespBody> {
    private static final LoginRespBodySerializer INSTANCE = new LoginRespBodySerializer();

    public static LoginRespBodySerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) {

    }

    @Override
    public LoginRespBody deserializer(ByteBuf in) {
        return new LoginRespBody();
    }
}
