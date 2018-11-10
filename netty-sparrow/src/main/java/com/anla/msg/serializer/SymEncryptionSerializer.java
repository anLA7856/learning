package com.anla.msg.serializer;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Body;
import com.anla.msg.body.SymEncryption;
import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @author anLA7856
 * @createTime 2018/7/29
 * @description
 */


public class SymEncryptionSerializer implements BodySerializer<SymEncryption> {
    private static final SymEncryptionSerializer INSTANCE = new SymEncryptionSerializer();

    public static SymEncryptionSerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) throws UnsupportedEncodingException {
        SymEncryption SymEncryption = (SymEncryption) body;
        Encoder.writeString(out, SymEncryption.getSymEncryptionMethod());
    }

    @Override
    public SymEncryption deserializer(ByteBuf in) throws UnsupportedEncodingException {
        String symEncryptionMethod = Decoder.readString(in);
        SymEncryption symEncryption = new SymEncryption();
        symEncryption.setSymEncryptionMethod(symEncryptionMethod);
        return symEncryption;
    }
}
