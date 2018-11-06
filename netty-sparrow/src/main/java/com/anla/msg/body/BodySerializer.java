package com.anla.msg.body;

import io.netty.buffer.ByteBuf;

/**
 * @user anLA7856
 * @time 18-11-6 下午11:52
 * @description 用于解析共用抽象父类
 */
public interface BodySerializer<T> {
    public void serializer(ByteBuf out, Body body) throws Exception;

    public T deserializer(ByteBuf in) throws Exception;
}
