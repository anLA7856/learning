package com.anla.client.handler;

import io.netty.channel.ChannelHandlerContext;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:33
 * @description 说明是个trigger类型的handler
 */
public interface ITriggerHandler {
    default void launch(ChannelHandlerContext ctx){

    }
}
