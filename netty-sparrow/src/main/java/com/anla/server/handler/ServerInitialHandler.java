package com.anla.server.handler;

import com.anla.core.DynamicMsgDecoder;
import com.anla.core.DynamicMsgEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @user anLA7856
 * @time 18-11-1 下午11:19
 * @description 用于初始化服务端的channelhandler
 */
public class ServerInitialHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new DynamicMsgDecoder());
        ch.pipeline().addLast(new DynamicMsgEncoder());
        ch.pipeline().addLast(new IdleStateHandler(5, 5, 0, TimeUnit.SECONDS));
        ch.pipeline().addLast(new HeartBeatServerHandler());
        ch.pipeline().addLast(new SslServerHandler());
        ch.pipeline().addLast(new SymEncryptionServerHandler());
        ch.pipeline().addLast(new LoginRespHandler());
        ch.pipeline().addLast(new ExceptionHandler());
    }
}
