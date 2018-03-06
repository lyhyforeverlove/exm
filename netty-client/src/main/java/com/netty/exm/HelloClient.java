package com.netty.exm;

import com.netty.exm.handler.HelloClientHandler;
import com.netty.exm.initializer.HelloClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloClient {

    final String host;
    final int port;
    public HelloClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class).remoteAddress(host,port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("framer",new DelimiterBasedFrameDecoder((int) 8192
                                            , Delimiters.lineDelimiter()))
                                    .addLast("decode",new StringDecoder())
                                    .addLast("encode",new StringEncoder())
                                    .addLast(new HelloClientHandler());
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE,true);
            //连接服务端
            Channel ch = b.connect().sync().channel();

            //控制台输出
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;){
                String line = in.readLine();
                if (line == null) {
                    continue;
                }
                /** 向服务端发送在控制台输入的文本 并用"\r\n"结尾
                 * 之所以用\r\n结尾 是因为我们在handler中添加了 DelimiterBasedFrameDecoder 帧解码。
                 * 这个解码器是一个根据\n符号位分隔符的解码器。所以每条消息的最后必须加上\n否则无法识别和解码
                 */
                ch.writeAndFlush(line + "\r\n");

            }

        } finally {
            group.shutdownGracefully();
        }


    }

    public static void main(String[] args)throws Exception {
        new HelloClient("127.0.0.1",7878).start();
    }



}
