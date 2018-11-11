package com.anla.client.handler;

import io.netty.channel.ChannelHandlerContext;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:33
 * @description 说明是个trigger类型的handler
 */
public interface ITriggerHandler {
    /**
     * 每次由该类型handler被加入时调用，用于向服务端发送相应消息
     * @param ctx
     */
    default void launch(ChannelHandlerContext ctx){

    }
}
