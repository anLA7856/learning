package com.anla.msg.serializer;

import com.anla.core.Decoder;
import com.anla.core.Encoder;
import com.anla.msg.Body;
import com.anla.msg.body.RandomCodeBody;
import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @author anLA7856
 * @createTime 18-11-9 下午11:21
 * @description
 */


public final class RandomCodeBodySerializer implements BodySerializer<RandomCodeBody> {
    private static final RandomCodeBodySerializer INSTANCE = new RandomCodeBodySerializer();

    public static RandomCodeBodySerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf outByteBuf, Body body) throws UnsupportedEncodingException {
        RandomCodeBody randomCodeBody = (RandomCodeBody)body;
        Encoder.writeString(outByteBuf, randomCodeBody.getRandomCode());
    }

    @Override
    public RandomCodeBody deserializer(ByteBuf inByteBuf) throws UnsupportedEncodingException {
        String randomCode = Decoder.readString(inByteBuf);
        RandomCodeBody randomCodeBody = new RandomCodeBody();
        randomCodeBody.setRandomCode(randomCode);
        return randomCodeBody;
    }
}
