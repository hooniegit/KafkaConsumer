package com.example.KafkaConsumer.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

//    private final String host01;
//    private final int port01;
//    private EventLoopGroup group01;
//    
//    private final String host02;
//    private final int port02;
//    private EventLoopGroup group02;
//    
//    private final String host03;
//    private final int port03;
//    private EventLoopGroup group03;
//
//    public ClientService(@Value("${netty.server.host}") String host01,
//                         @Value("${netty.server.port}") int port01,
//                         @Value("${netty.server.host}") String host02,
//                         @Value("${netty.server.port}") int port02,
//                         @Value("${netty.server.host}") String host03,
//                         @Value("${netty.server.port}") int port03) {
//        this.host01 = host01;
//        this.port01 = port01;
//        this.group01 = new NioEventLoopGroup();
//        this.host02 = host02;
//        this.port02 = port02;
//        this.group02 = new NioEventLoopGroup();
//        this.host03 = host03;
//        this.port03 = port03;
//        this.group03 = new NioEventLoopGroup();
//    }
//    
//    public Channel getConnection(String LOCATION) throws Exception {
//    	if (LOCATION.equals("LOC01")) {
//	        Bootstrap b = new Bootstrap();
//	        b.group(group01)
//	         .channel(NioSocketChannel.class)
//	         .handler(new ChannelInitializer<SocketChannel>() {
//	             @Override
//	             protected void initChannel(SocketChannel ch) throws Exception {
//	                 ChannelPipeline p = ch.pipeline();
//	                 p.addLast(new DelimiterBasedFrameDecoder(32768000, Delimiters.lineDelimiter()));
//	                 p.addLast(new StringDecoder());
//	                 p.addLast(new StringEncoder());
//	             }
//	         });
//	
//	        ChannelFuture f = b.connect(host01, port01).sync();
//	        return f.channel();
//    	} else if (LOCATION.equals("LOC02")) {
//	        Bootstrap b = new Bootstrap();
//	        b.group(group02)
//	         .channel(NioSocketChannel.class)
//	         .handler(new ChannelInitializer<SocketChannel>() {
//	             @Override
//	             protected void initChannel(SocketChannel ch) throws Exception {
//	                 ChannelPipeline p = ch.pipeline();
//	                 p.addLast(new DelimiterBasedFrameDecoder(32768000, Delimiters.lineDelimiter()));
//	                 p.addLast(new StringDecoder());
//	                 p.addLast(new StringEncoder());
//	             }
//	         });
//	
//	        ChannelFuture f = b.connect(host02, port02).sync();
//	        return f.channel();
//    	} else if (LOCATION.equals("LOC03")) {
//	        Bootstrap b = new Bootstrap();
//	        b.group(group03)
//	         .channel(NioSocketChannel.class)
//	         .handler(new ChannelInitializer<SocketChannel>() {
//	             @Override
//	             protected void initChannel(SocketChannel ch) throws Exception {
//	                 ChannelPipeline p = ch.pipeline();
//	                 p.addLast(new DelimiterBasedFrameDecoder(32768000, Delimiters.lineDelimiter()));
//	                 p.addLast(new StringDecoder());
//	                 p.addLast(new StringEncoder());
//	             }
//	         });
//	
//	        ChannelFuture f = b.connect(host03, port03).sync();
//	        return f.channel();
//    	} else {
//    		return null;
//    	}
//    }
//
//    public void sendData(Channel channel, String data) throws Exception {
//        if (channel != null && channel.isActive()) {
//            channel.writeAndFlush(data);
//        } else {
//            throw new IllegalStateException("[Connection] Channel is Not Opened.");
//        }
//    }
//    
//    public void disconnect(Channel channel) throws Exception {
//        if (channel != null) {
//            channel.close().sync();
//        }
//    } 

}