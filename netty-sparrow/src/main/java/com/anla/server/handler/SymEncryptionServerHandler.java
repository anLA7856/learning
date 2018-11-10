package com.anla.server.handler;

import com.anla.msg.Message;
import com.anla.msg.MsgType;
import com.anla.msg.body.SymEncryption;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午4:47
 * @description 加密算法
 */
public class SymEncryptionServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(SymEncryptionServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (Message) msg;
        MsgType msgType = message.getHeader().getType();
        if(MsgType.SYM_ENCRYPTION.equals(msgType)){
            LOGGER.info("receive sym_encryptiom req.");
            SymEncryption symEncryption = (SymEncryption) message.getBody();
            ctx.channel().writeAndFlush(buildSymEncryption(symEncryption.getSymEncryptionMethod()));
        }else {
            ctx.fireChannelRead(msg);
        }
    }

    private Object buildSymEncryption(String symEncryptionMethod) {
        SymEncryption symEncryption = new SymEncryption();
        symEncryption.setSymEncryptionMethod(symEncryptionMethod);
        return Message.createMsgOfEncode(symEncryption);
    }
}
