package com.anla.client.handler;

import com.anla.client.event.TriggerEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:24
 * @description
 */
public class ClientInitHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(ClientInitHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("channel is active , remote channel {}", ctx.channel().remoteAddress());
        ctx.fireUserEventTriggered(TriggerEvent.SSL_EVENT);   //传入的是一个object，也就是事件
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("inactive channel {}", ctx.channel().remoteAddress());
        ctx.fireChannelInactive();
    }
}
