package com.anla.client.handler;

import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.HeartBeatReqBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午8:31
 * @description 触发心跳
 */
public class HeartbeatClientHandler extends ChannelInboundHandlerAdapter implements ITriggerHandler {
    private static final Logger LOGGER = LogManager.getLogger(HeartbeatClientHandler.class);
    private int lossConnectTime = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE){
                lossConnectTime ++;
                if(lossConnectTime > 6){
                    LOGGER.error("heartbeat timeout. close channel {}", ctx.channel().remoteAddress());
                    ctx.close();
                }
            }else if(idleStateEvent.state() == IdleState.WRITER_IDLE) {
                LOGGER.warn("heartbeat timeout. lossCount {}", lossConnectTime);
                ctx.writeAndFlush(buildHtReqMsg());
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.HEARTBEAT_RESP.equals(msgType)){
            LOGGER.info("receive heartbeat message");
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Object buildHtReqMsg() {
        HeartBeatReqBody heartBeatReqBody = new HeartBeatReqBody();
        return Message.createMsgOfEncode(heartBeatReqBody);
    }
}
