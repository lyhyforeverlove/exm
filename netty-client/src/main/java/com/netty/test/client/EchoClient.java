package com.netty.test.client;

import com.netty.exm.handler.HelloClientHandler;
import com.netty.test.handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EchoClient {

    final String host;
    final int port;

    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception{
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();

            b.group(work).channel(NioSocketChannel.class).remoteAddress(host,port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture future = b.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully().sync();
        }


    }

    public static void main(String[] args)throws Exception {
        new EchoClient("127.0.0.1",7879).start();
    }


}
