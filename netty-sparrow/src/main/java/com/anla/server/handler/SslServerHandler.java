package com.anla.server.handler;

import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.SslBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午4:35
 * @description 用于处理ssl事件
 */
public class SslServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(SslServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.SSL.equals(msgType)){
            LOGGER.info("receive ssl message");
            SslBody sslBody = (SslBody) message.getBody();
            ctx.channel().writeAndFlush(buildSslBody(sslBody.getSslVersion()));
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Object buildSslBody(String sslVersion) {
        SslBody sslBody = new SslBody();
        sslBody.setSslVersion(sslVersion);
        return Message.createMsgOfEncode(sslBody);
    }
}
