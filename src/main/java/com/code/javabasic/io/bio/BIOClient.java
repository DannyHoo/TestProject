package com.code.javabasic.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danny
 * @Title: BIOClient
 * @Description:
 * @Created on 2019-01-16 13:52:03
 */
public class BIOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService threadPool= Executors.newCachedThreadPool();

        BIOClient client=new BIOClient();
        Socket socket=null;
        try {
            socket=client.createSocket();
            client.sendMessage(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       /* while (true){
            Thread.sleep(new Random().nextInt(1000));
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    BIOClient client=new BIOClient();
                    Socket socket=null;
                    try {
                        socket=client.createSocket();
                        client.sendMessage(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }*/
    }

    public Socket createSocket() throws IOException {
        return new Socket("127.0.0.1",8080);
    }

    public void sendMessage(Socket socket) throws IOException {
        String content="This is a message from a client!";
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write(new String(content).getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
