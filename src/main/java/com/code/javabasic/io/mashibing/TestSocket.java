package com.code.javabasic.io.mashibing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author danny
 * @date 2020/4/8下午9:36
 */
public class TestSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8090);
        System.out.println("step1:new ServerSocket(8090)");
        while (true){
            Socket client=serverSocket.accept(); //如果没有客户端连接会在此阻塞
            System.out.println("step2:client\t"+client.getPort());
            InputStream inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            while (true){
                System.out.println(bufferedReader.readLine()); //如果客户端不发送数据会在此阻塞
                System.out.println(bufferedReader.readLine());
            }
        }
    }

}
