package com.anla.msg.serializer;

import com.anla.msg.Body;
import com.anla.msg.body.HeartbeatRespBody;
import io.netty.buffer.ByteBuf;

/**
 * @author anLA7856
 * @createTime 2018/7/29
 * @description
 */


public final class HeartRespBodySerializer implements BodySerializer<HeartbeatRespBody> {

    private static final HeartRespBodySerializer INSTANCE = new HeartRespBodySerializer();

    public static HeartRespBodySerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) throws Exception {

    }

    @Override
    public HeartbeatRespBody deserializer(ByteBuf in) throws Exception {
        return new HeartbeatRespBody();
    }
}
