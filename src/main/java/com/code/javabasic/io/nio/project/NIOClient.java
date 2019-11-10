package com.code.javabasic.io.nio.project;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Danny
 * @Title: NIOClient
 * @Description:
 * @Created on 2019-01-10 23:05:10
 */
public class NIOClient {

    private static int blockSize = 4 * 1024;
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);
    private final static InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 7080);

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(inetSocketAddress);

        Set<SelectionKey> selectionKeySet;
        Iterator<SelectionKey> iterator;
        SelectionKey selectionKey;
        SocketChannel clientChannel;
        String sendText;
        String receiveText;
        int count;
        new Thread().interrupt();
        while (true) {
            selector.select();
            selectionKeySet = selector.selectedKeys();
            iterator = selectionKeySet.iterator();
            while (iterator.hasNext()) {
                selectionKey = iterator.next();
                if (selectionKey.isConnectable()) {
                    System.out.println("客户端和服务端建立连接【0】");
                    clientChannel = (SocketChannel) selectionKey.channel();
                    if (clientChannel.isConnectionPending()) {//是否真的建立完成
                        clientChannel.finishConnect();
                        System.out.println("客户端已经和服务端建立连接完成【1】");
                        sendBuffer.clear();
                        sendBuffer.put("这是客户端发送的内容【2】".getBytes());
                        sendBuffer.flip();
                        clientChannel.write(sendBuffer);
                    }
                    clientChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    clientChannel = (SocketChannel) selectionKey.channel();
                    receiveBuffer.clear();
                    count = clientChannel.read(receiveBuffer);
                    if (count > 0) {
                        receiveText = new String(receiveBuffer.array(), 0, count);
                        System.out.println("客户端接收到服务端的内容【3】：" + receiveText);
                        clientChannel.register(selector, SelectionKey.OP_WRITE);
                    }
                } else if (selectionKey.isWritable()) {
                    clientChannel = (SocketChannel) selectionKey.channel();
                    sendBuffer.clear();
                    sendText = "这是客户端发送的内容【4】";
                    sendBuffer.put(sendText.getBytes());
                    sendBuffer.flip();
                    clientChannel.write(sendBuffer);
                    System.out.println("客户端发送数据给客户端【5】，内容：" + sendText);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                }
                Thread.sleep(1000);
            }
            selectionKeySet.clear();
        }

    }

}
