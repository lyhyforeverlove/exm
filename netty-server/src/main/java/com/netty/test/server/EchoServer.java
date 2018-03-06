package com.netty.test.server;

import com.netty.test.handler.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;

public class EchoServer {

    final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        EventLoopGroup boss = new NioEventLoopGroup();
        ServerBootstrap sb = new ServerBootstrap();

        try {
            sb.group(boss).channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture future = sb.bind().sync();
            System.out.println(EchoServer.class.getName() + "started and listen on " + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully().sync();
        }


    }

    public static void main(String[] args)throws Exception {
        new EchoServer(7879).start();
    }

}
