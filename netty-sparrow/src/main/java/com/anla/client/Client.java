package com.anla.client;

import com.anla.client.handler.ChildChannelHandler;
import com.anla.util.CustomerThreadFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-10 下午5:16
 * @description Client的启动代码
 */
public class Client {
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private EventLoopGroup group = new NioEventLoopGroup(1, new CustomerThreadFactory("clientGroup", true));

    public void start(String ip, int port){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new ChildChannelHandler());
        bootstrap.connect(ip, port).addListener((future)->{
           if(future.isSuccess()){
               LOGGER.info("connect {} : {} success",ip, port);
           } else {
               LOGGER.info("connct {}:{} fail", ip, port, future.cause());
           }
        });
    }

    public void stop(){
        if (group != null){
            group.shutdownGracefully();
        }
    }
}
