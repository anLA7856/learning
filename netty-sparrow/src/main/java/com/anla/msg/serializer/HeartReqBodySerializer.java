package com.anla.msg.serializer;

import com.anla.msg.Body;
import com.anla.msg.body.HeartBeatReqBody;
import io.netty.buffer.ByteBuf;

/**
 * @user anLA7856
 * @time 18-11-7 下午11:20
 * @description request实体的解析类
 */
public class HeartReqBodySerializer implements BodySerializer<HeartBeatReqBody>{

    private static final HeartReqBodySerializer INSTANCE = new HeartReqBodySerializer();

    public static HeartReqBodySerializer getInstance(){ return INSTANCE;}

    @Override
    public void serializer(ByteBuf out, Body body) throws Exception {

    }

    @Override
    public HeartBeatReqBody deserializer(ByteBuf in) throws Exception {
        return new HeartBeatReqBody();
    }
}
