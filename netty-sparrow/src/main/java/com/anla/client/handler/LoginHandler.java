package com.anla.client.handler;

import com.anla.client.event.TriggerEvent;
import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.LoginReqBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午8:23
 * @description 发起登录请求
 */
public class LoginHandler extends ChannelInboundHandlerAdapter implements ITriggerHandler {
    private static final Logger LOGGER = LogManager.getLogger(LoginHandler.class);

    private static final String USERNAME = "anLA7856";
    private static final String PASSWORD = "123456";

    @Override
    public void launch(ChannelHandlerContext ctx) {
        LOGGER.info("login sent");
        ctx.writeAndFlush(buildLoginReqBody());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.LOGIN_RESP.equals(msgType)){
            LOGGER.info("receive resp msg, launch heartbeat");
            ctx.fireUserEventTriggered(TriggerEvent.HEARTBEAT_EVENT);
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Object buildLoginReqBody() {
        LoginReqBody loginRespBody= new LoginReqBody();
        loginRespBody.setUserName(USERNAME);
        loginRespBody.setPassword(PASSWORD);
        return Message.createMsgOfEncode(loginRespBody);
    }
}
