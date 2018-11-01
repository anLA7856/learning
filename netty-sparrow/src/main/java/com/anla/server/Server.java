package com.anla.server;

import com.anla.util.CustomerThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @user anLA7856
 * @time 18-11-1 下午10:51
 * @description 用于服务端的启动
 */
public class Server {
    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup(2, new CustomerThreadFactory("sparrow", true));

    public void start (int port){
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)   //https://blog.csdn.net/zhousenshan/article/details/72859923
                .childHandler(new ChildChannelHandler());
        ChannelFuture future = bootstrap.bind(port);
        LOGGER.info("server started at port:{}", port);
        future.addListener((param)->{
            if(param.isSuccess()){
                LOGGER.info("server bind success!");
            }else {
                LOGGER.info("server bind failed", param.cause());
            }
        });
    }
}
