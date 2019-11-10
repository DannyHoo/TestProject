package com.code.javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Danny
 * @Title: CopyFile
 * @Description:
 * @Created on 2019-01-16 11:18:11
 */
public class CopyFile {

    public static void main(String[] args) {
        String resource = "/Users/dannyhoo/data/files/tempFile";
        String destination = "/Users/dannyhoo/data/files/tempFile1";

        ioCopyFile(resource, destination);
        //nioCopyFile(resource,destination);
    }

    //传统io复制文件
    //1.58G，buffer 8 bytes，IO复制文件耗时：597,348ms
    //1.58G，buffer 1024*1024 bytes，IO复制文件耗时：38,722ms/28483ms
    public static void ioCopyFile(String resource, String destination) {
        byte[] buffer = new byte[1024 * 1024];
        try (FileInputStream fileInputStream = new FileInputStream(resource);
             FileOutputStream fileOutputStream = new FileOutputStream(destination);) {

            int read = 0;
            long startTime = System.currentTimeMillis();
            while ((read = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
            System.out.println("IO复制文件耗时：" + (System.currentTimeMillis() - startTime));
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //nio复制文件
    //1.58G，buffer 1024*1024 bytes，IO复制文件耗时：30,885ms
    public static void nioCopyFile(String resource, String destination) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel readChannel = null;
        FileChannel writeChannel = null;
        try {
            fileInputStream = new FileInputStream(resource);
            fileOutputStream = new FileOutputStream(destination);

            readChannel = fileInputStream.getChannel();
            writeChannel = fileOutputStream.getChannel();

            int bufferSize = 1024 * 1024;
            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            byteBuffer.clear();

            long startTime = System.currentTimeMillis();
            while (readChannel.position() != readChannel.size()) {
                if (readChannel.size() - readChannel.position() < bufferSize) {//通道中最后一段数据且长度小于buffer的长度
                    long lastBufferSize = readChannel.size() - readChannel.position();
                    readChannel.transferTo(readChannel.position(), lastBufferSize, writeChannel);
                    readChannel.position(readChannel.position() + lastBufferSize);
                } else {
                    readChannel.transferTo(readChannel.position(), bufferSize, writeChannel);
                    readChannel.position(readChannel.position() + bufferSize);
                }
            }
            System.out.println("NIO复制文件耗时：" + (System.currentTimeMillis() - startTime));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (readChannel != null) readChannel.close();
                if (writeChannel != null) writeChannel.close();
                if (fileInputStream != null) fileInputStream.close();
                if (fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //nio内存映射复制文件
    //1.58G，buffer 1024*1024 bytes，IO复制文件耗时：30,885ms
    public static void nioMapCopyFile(String resource, String destination) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel readChannel = null;
        FileChannel writeChannel = null;

        try {
            fileInputStream = new FileInputStream(resource);
            fileOutputStream=new FileOutputStream(destination);
            readChannel=fileInputStream.getChannel();
            writeChannel=fileOutputStream.getChannel();

            MappedByteBuffer mappedByteBuffer=readChannel.map(FileChannel.MapMode.READ_ONLY,0,readChannel.size());
            writeChannel.write(mappedByteBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
