package com.anla.client.handler;

import com.anla.core.DynamicMsgDecoder;
import com.anla.core.DynamicMsgEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:20
 * @description
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new DynamicMsgEncoder());
        ch.pipeline().addLast(new DynamicMsgDecoder());
        ch.pipeline().addLast(new ClientInitHandler());
        ch.pipeline().addLast(TriggerHandler.class.getSimpleName(), new TriggerHandler());
    }
}
