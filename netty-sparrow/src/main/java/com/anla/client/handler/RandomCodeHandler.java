package com.anla.client.handler;

import com.anla.client.event.TriggerEvent;
import com.anla.msg.Message;
import com.anla.msg.body.RandomCodeBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午8:07
 * @description
 */
public class RandomCodeHandler extends ChannelInboundHandlerAdapter implements ITriggerHandler {
    private static final Logger LOGGER = LogManager.getLogger(RandomCodeHandler.class);
    private static final String RANDOM_CODE = "anLA7856";

    @Override
    public void launch(ChannelHandlerContext ctx) {
        LOGGER.info(" random code sent");
        ctx.writeAndFlush(buildRandomCodeBody());
        // 发起登录请求
        LoginHandler loginHandler = new LoginHandler();
        ctx.pipeline().addBefore(TriggerEvent.class.getSimpleName(), RandomCodeHandler.class.getSimpleName(), loginHandler);
    }

    private Object buildRandomCodeBody() {
        RandomCodeBody randomCodeBody = new RandomCodeBody();
        randomCodeBody.setRandomCode(RANDOM_CODE);
        return Message.createMsgOfEncode(randomCodeBody);
    }
}
