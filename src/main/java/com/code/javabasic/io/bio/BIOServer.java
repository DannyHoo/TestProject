package com.code.javabasic.io.bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danny
 * @Title: BIOServer
 * @Description:
 * @Created on 2019-01-12 20:30:04
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
//        initServerSocket();
        initServerSocketMultiThread();
    }

    //初始化服务端（单线程处理任务）
    public static void initServerSocket() throws IOException {
        //创建socket服务，监听8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("单线程服务端启动");

        //获取一个客户端套接字（阻塞）
        Socket socket = serverSocket.accept();
        System.out.println("接收到一个客户端");

        handle(socket);
    }

    //初始化服务端（多线程处理任务）
    public static void initServerSocketMultiThread() throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //创建socket服务，监听8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("多线程服务端启动");

        while (true) {
            //获取一个客户端套接字（阻塞）
            final Socket socket = serverSocket.accept();
            System.out.println("接收到一个客户端");

            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        handle(socket);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //按行读取
    private static void handle(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuffer stringBuffer=new StringBuffer();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuffer.append(temp);
        }
        System.out.println("接收到客户端消息：" + stringBuffer.toString());
    }

    //按字节读取
    private static void handle1(Socket socket) throws IOException {
        while (true) {
            byte[] bytes = new byte[8];
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read(bytes);//阻塞
            String str = new String(bytes);
            if (read != -1) {
                System.out.println("接收到客户端消息：" + new String(bytes, 0, read));
            }
        }
    }
}
