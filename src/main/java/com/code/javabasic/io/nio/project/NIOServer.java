package com.code.javabasic.io.nio.project;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author Danny
 * @Title: NIOServer
 * @Description:
 * @Created on 2019-01-10 21:56:31
 */
public class NIOServer {

    /* 缓冲区块大小 */
    private int blockSize = 4 * 1024;
    /* 发送缓冲区大小 */
    private ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
    /* 接收缓冲区大小 */
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);

    private Selector selector;

    public NIOServer(int port) throws IOException {
        //打开服务端套接字通道Channel，
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //服务端配置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //检索与服务器通道关联的套接字Socket
        ServerSocket serverSocket = serverSocketChannel.socket();
        //通过服务端关联的套接字Socket绑定服务端IP和端口
        serverSocket.bind(new InetSocketAddress(port));
        //通过open方法打开选择器
        selector = Selector.open();
        //把服务端端Channel的接收请求事件注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动! 端口:" + port);
    }

    //监听
    public void listen() throws IOException, InterruptedException {
        while (true) {
            //监听所有通道的事件
            //当没有通道有事件发生时，selector.select()会阻塞
            int readyNum=selector.select();
            System.out.println("readNum:"+readyNum);

            //返回此选择器的已选键集
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator=selectionKeySet.iterator();
            //遍历选择器当前的所有事件
            while (iterator.hasNext()){
                SelectionKey selectionKey=iterator.next();
                handleKey(selectionKey);//业务逻辑处理
                iterator.remove();//删除已经处理的事件
                Thread.sleep(1000);
            }
        }
    }

    public void handleKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverChannel=null;
        SocketChannel clientChannel=null;
        String receiveText;
        String sendText;
        int count=0;
        if (selectionKey.isAcceptable()){//服务端的接收连接事件
            serverChannel= (ServerSocketChannel) selectionKey.channel();//获得服务端的Channel
            clientChannel=serverChannel.accept();//接收客户端的连接并获得客户端Channel
            clientChannel.configureBlocking(false);//设置客户端的Channel为非阻塞
            System.out.println("服务端已接收接到客户端的连接请求");
            clientChannel.register(selector,SelectionKey.OP_READ);//把客户端的读事件注册到选择器上
        }else if (selectionKey.isReadable()){//服务端的读事件
            clientChannel= (SocketChannel) selectionKey.channel();//获得客户端Channel
            count=clientChannel.read(receiveBuffer);//从客户端的Channel读数据
            if (count>0){
                receiveText=new String(receiveBuffer.array(),0,count);
                System.out.println("服务端接收到客户端的数据："+receiveText);
            }
            clientChannel.register(selector,SelectionKey.OP_WRITE);
        }else if (selectionKey.isWritable()){//服务端的写事件
            sendBuffer.clear();
            clientChannel= (SocketChannel) selectionKey.channel();
            sendText="服务端向客户端发送的内容"+new Random().nextInt();
            sendBuffer.put(sendText.getBytes());
            sendBuffer.flip();
            clientChannel.write(sendBuffer);//向客户端发送数据
            System.out.println("服务端已经向客户端发送数据："+sendText);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        NIOServer nioServer=new NIOServer(7080);
        nioServer.listen();
    }
}
