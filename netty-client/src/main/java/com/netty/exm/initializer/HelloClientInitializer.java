package com.netty.exm.initializer;

import com.netty.exm.handler.HelloClientHandler;
import com.netty.exm.handler.HelloClientHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class HelloClientInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                /**这个地方必须对应上
                 *
                 */
                .addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()))
                .addLast("decoder",new StringDecoder())
                .addLast("encoder",new StringEncoder())
                //客户端逻辑
                .addLast("hanlder",new HelloClientHandler());
    }
}
