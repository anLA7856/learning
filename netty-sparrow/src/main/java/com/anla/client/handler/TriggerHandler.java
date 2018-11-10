package com.anla.client.handler;

import com.anla.client.event.TriggerEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午8:14
 * @description
 */
public class TriggerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(TriggerHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof TriggerEvent){
            TriggerEvent triggerEvent = (TriggerEvent) evt;
            LOGGER.info("trigger TriggerHanlder {}", triggerEvent);
            triggerEvent.trigger(ctx, TriggerEvent.class);
        }else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("happen unknow exception. ", cause);
    }
}
