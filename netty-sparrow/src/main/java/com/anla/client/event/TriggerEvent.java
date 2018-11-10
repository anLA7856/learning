package com.anla.client.event;


import com.anla.client.handler.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:30
 * @description 自定义的TriggerEvent
 */
public enum TriggerEvent {
    /**
     * ssl 事件
     */
    SSL_EVENT(SslHandler.class){
        @Override
        protected ITriggerHandler trigger0(ChannelHandlerContext ctx, Class<?> baseClazz) {
            SslHandler sslHandler = new SslHandler();
            ctx.pipeline().addBefore(baseClazz.getSimpleName(), getClazz().getSimpleName(), sslHandler);
            return sslHandler;
        }
    },
    /**
     * 对称加密
     */
    SYM_ENCRYPTION_EVENT(SymEncryptionHandler.class) {
        @Override
        protected ITriggerHandler trigger0(ChannelHandlerContext ctx, Class<?> baseClazz) {
            SymEncryptionHandler symEncryptionHandler = new SymEncryptionHandler();
            ctx.pipeline().addBefore(baseClazz.getSimpleName(), getClazz().getSimpleName(), symEncryptionHandler);
            return symEncryptionHandler;
        }
    },
    /**
     * 随机数加密。 {@see SymEncryptionHandler}
     */
    RANDOM_CODE_EVENT(RandomCodeHandler.class) {
        @Override
        protected ITriggerHandler trigger0(ChannelHandlerContext ctx, Class<?> baseClazz) {
            RandomCodeHandler randomCodeHandler = new RandomCodeHandler();
            ctx.pipeline().addBefore(baseClazz.getSimpleName(), getClazz().getSimpleName(), randomCodeHandler);
            return randomCodeHandler;
        }
    },
    /**
     * 心跳事件. {@see HeartbeatClientHandler}
     */
    HEARTBEAT_EVENT(HeartbeatClientHandler.class) {
        @Override
        protected ITriggerHandler trigger0(ChannelHandlerContext ctx, Class<?> baseClazz) {
            ctx.channel().pipeline().addBefore(baseClazz.getSimpleName() ,IdleStateHandler.class.getSimpleName(), new IdleStateHandler(5, 5, 0, TimeUnit.SECONDS));

            HeartbeatClientHandler htClientHandler = new HeartbeatClientHandler();
            ctx.pipeline().addBefore(baseClazz.getSimpleName(), getClazz().getSimpleName(), htClientHandler);
            return htClientHandler;
        }
    };
    ;

    private Class<? extends ITriggerHandler> clazz;

    TriggerEvent(Class<? extends ITriggerHandler> clazz){
        this.clazz = clazz;
    }



    public void trigger(ChannelHandlerContext ctx, Class<?> baseClazz){
        trigger0(ctx, baseClazz);
    }

    /**
     * 枚举必须实现
     * @param ctx
     * @param baseClazz
     * @return
     */
    protected abstract ITriggerHandler trigger0(ChannelHandlerContext ctx, Class<?> baseClazz);

    public Class<? extends ITriggerHandler> getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return clazz.getSimpleName();
    }
}