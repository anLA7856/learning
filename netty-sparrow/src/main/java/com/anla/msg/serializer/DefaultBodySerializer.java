package com.anla.msg.serializer;

import com.anla.msg.Body;
import io.netty.buffer.ByteBuf;

/**
 * @user anLA7856
 * @time 18-11-7 上午12:02
 * @description 默认的body解析器
 */
public class DefaultBodySerializer implements BodySerializer<Body>{

    private static final DefaultBodySerializer INSTANCE = new DefaultBodySerializer();

    public static DefaultBodySerializer getInstance(){
        return INSTANCE;
    }

    @Override
    public void serializer(ByteBuf out, Body body) throws Exception {

    }

    @Override
    public Body deserializer(ByteBuf in) throws Exception {
        return new Body();
    }
}
