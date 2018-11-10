package com.anla.client.handler;

import com.anla.client.event.TriggerEvent;
import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.SslBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:31
 * @description
 */
public class SslHandler extends ChannelInboundHandlerAdapter implements ITriggerHandler{
    private static final Logger LOGGER = LogManager.getLogger(SslHandler.class);
    private static final String SSL_VERSION = "3.2.2";

    @Override
    public void launch(ChannelHandlerContext ctx) {
        LOGGER.info("ssl sent");
        ctx.writeAndFlush(buildSslBody());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.SSL.equals(msgType)){
            LOGGER.info("receive ssl resp. launch symEncryption");
            ctx.fireUserEventTriggered(TriggerEvent.SYM_ENCRYPTION_EVENT);
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Message buildSslBody() {
        SslBody sslBody = new SslBody();
        sslBody.setSslVersion(SSL_VERSION);
        return Message.createMsgOfEncode(sslBody);
    }
}
