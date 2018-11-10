package com.anla.server.handler;

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
 * @time 18-11-8 下午11:47
 * @description 服务端心跳接受
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(HeartBeatServerHandler.class);
    private int lossConnectTime = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if(event.state() == IdleState.READER_IDLE){
                lossConnectTime++;
                if(lossConnectTime > 6){
                    LOGGER.error("heartbeat timeout. close channel {}", ctx.channel().remoteAddress());
                    ctx.close();
                }
            }else if(event.state() == IdleState.WRITER_IDLE){
                LOGGER.warn("heartbeat timeout. lossCount {}", lossConnectTime);
                ctx.writeAndFlush(buildHtReqMsg());
            }
        }else {
            ctx.fireUserEventTriggered(evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        lossConnectTime = 0;    //置0
        if(MsgType.HEARTBEAT_RESP.equals(msgType)){
            LOGGER.debug("receive debug message");
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Message buildHtReqMsg() {
        HeartBeatReqBody heartBeatReqBody = new HeartBeatReqBody();
        return Message.createMsgOfEncode(heartBeatReqBody);
    }
}
