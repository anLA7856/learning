package com.anla.server.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @user anLA7856
 * @time 18-11-1 下午11:19
 * @description 用于初始化服务端的channelhandler
 */
public class ServerInitialHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast()
    }
}
