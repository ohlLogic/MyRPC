package com.ohl.MyRPCVersion4.client;

import com.ohl.MyRPCVersion4.codec.JsonSerializer;
import com.ohl.MyRPCVersion4.codec.MyDecode;
import com.ohl.MyRPCVersion4.codec.MyEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //使用自定义的编码器
        pipeline.addLast(new MyDecode());
        //传入序列化器
        pipeline.addLast(new MyEncode(new JsonSerializer()));
        pipeline.addLast(new NettyClientHandler());
    }
}
