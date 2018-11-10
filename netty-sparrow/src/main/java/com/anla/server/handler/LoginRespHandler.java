package com.anla.server.handler;

import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.LoginReqBody;
import com.anla.msg.body.LoginRespBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午4:56
 * @description login resp
 */
public class LoginRespHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(LoginRespHandler.class);
    private static final String USERNAME = "anLA7856";
    private static final String PASSWORD = "123456";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.LOGIN_REQ.equals(msgType)){
            LOGGER.info("receive login req");
            LoginReqBody reqBody = (LoginReqBody) message.getBody();
            if(checkPermission(reqBody)){
                LOGGER.info("user check pass. login resp sent");
                ctx.channel().writeAndFlush(buildLoginResp());
            }else {
                ctx.fireChannelRead(msg);   // 纹丝不动还给它
            }
        }
    }

    private Object buildLoginResp() {
        LoginRespBody loginRespBody = new LoginRespBody();
        return Message.createMsgOfEncode(loginRespBody);
    }

    /**
     * 检查权限
     * @param reqBody
     * @return
     */
    private boolean checkPermission(LoginReqBody reqBody) {
        String username = reqBody.getUserName();
        String password = reqBody.getPassword();
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
