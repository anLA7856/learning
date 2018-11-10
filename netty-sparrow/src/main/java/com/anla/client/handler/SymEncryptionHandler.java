package com.anla.client.handler;

import com.anla.msg.Message;
import com.anla.msg.body.SymEncryption;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午6:08
 * @description
 */
public class SymEncryptionHandler extends ChannelInboundHandlerAdapter implements ITriggerHandler {
    private static final Logger LOGGER = LogManager.getLogger(SymEncryptionHandler.class);
    private static final String SYM_ENCRIPTION = "AES";

    @Override
    public void launch(ChannelHandlerContext ctx) {
        LOGGER.info("symEncription sent");
        ctx.writeAndFlush(buildSymEncription());
    }

    private Object buildSymEncription() {
        SymEncryption symEncryption = new SymEncryption();
        symEncryption.setSymEncryptionMethod(SYM_ENCRIPTION);
        return Message.createMsgOfEncode(symEncryption);
    }
}
