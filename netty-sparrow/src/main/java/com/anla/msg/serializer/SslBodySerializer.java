package com.anla.msg.serializer;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Body;
import com.anla.msg.body.SslBody;
import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @author anLA7856
 * @createTime 18-11-8 下午11:15
 * @description
 */


public final class SslBodySerializer implements BodySerializer<SslBody> {
    private static final SslBodySerializer INSTANCE = new SslBodySerializer();

    public static SslBodySerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) throws UnsupportedEncodingException {
        SslBody sslBody = (SslBody)body;
        Encoder.writeString(out, sslBody.getSslVersion());
    }

    @Override
    public SslBody deserializer(ByteBuf in) throws UnsupportedEncodingException {
        String sslVersion = Decoder.readString(in);

        SslBody sslBody =  new SslBody();
        sslBody.setSslVersion(sslVersion);

        return sslBody;
    }
}
