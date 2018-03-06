package com.netty.exm.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

public class HelloServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.err.println("收到消息--->: " + ctx.channel().remoteAddress() + " Say : " + msg);
        ctx.writeAndFlush("Received your message: " + msg.length() + "\n");
    }

    /**覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active ! ");
        ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service ! \n ");
//        super.channelActive(ctx);
    }
}
