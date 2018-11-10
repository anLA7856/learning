package com.anla.msg.serializer;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Body;
import com.anla.msg.body.LoginReqBody;
import io.netty.buffer.ByteBuf;

/**
 * @author anLA7856
 * @createTime 2018/7/29
 * @description
 */


public final class LoginReqBodySerializer implements BodySerializer<LoginReqBody> {
    private static final LoginReqBodySerializer INSTANCE = new LoginReqBodySerializer();
    public static LoginReqBodySerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) throws Exception {
        LoginReqBody login = (LoginReqBody)body;
        Encoder.writeString(out, login.getUserName());
        Encoder.writeString(out, login.getPassword());
    }

    @Override
    public LoginReqBody deserializer(ByteBuf in) throws Exception {
        String userName = Decoder.readString(in);
        String password = Decoder.readString(in);

        LoginReqBody loginReqBody = new LoginReqBody();
        loginReqBody.setUserName(userName);
        loginReqBody.setPassword(password);

        return loginReqBody;
    }
}
