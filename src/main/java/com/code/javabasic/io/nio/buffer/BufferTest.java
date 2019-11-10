package com.code.javabasic.io.nio.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Danny
 * @Title: BufferTest
 * @Description:
 * @Created on 2019-01-15 22:11:53
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        bufferInfo();
    }

    public static void bufferInfo() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);

        System.out.println("【初始化ByteBuffer】 limit:" + byteBuffer.limit() + " capacity:" + byteBuffer.capacity() + " position" + byteBuffer.position());

        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("【ByteBuffer写数据】 limit:" + byteBuffer.limit() + " capacity:" + byteBuffer.capacity() + " position" + byteBuffer.position());

        byteBuffer.flip();//读写转换/重置position，否则会抛BufferUnderflowException
        System.out.println("【ByteBuffer调flip】 limit:" + byteBuffer.limit() + " capacity:" + byteBuffer.capacity() + " position" + byteBuffer.position());

        for (int i = 0; i < 6; i++) {
            byteBuffer.get();
        }
        System.out.println("【ByteBuffer读数据】 limit:" + byteBuffer.limit() + " capacity:" + byteBuffer.capacity() + " position" + byteBuffer.position());
    }




}
