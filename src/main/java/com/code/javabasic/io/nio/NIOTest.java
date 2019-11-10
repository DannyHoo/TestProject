package com.code.javabasic.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.List;
import java.util.Random;

/**
 * @author Danny
 * @Title: NIOTest
 * @Description:
 * @Created on 2019-01-10 15:03:34
 */
public class NIOTest {

    public static void main(String[] args) {
        memoryMapped();

    }

    /**
     * NIO2里的变更通知机制
     * http://www.importnew.com/2000.html
     */
    public static void changeNotify() {
        String dirPath = "/Users/dannyhoo/data/files";
        Path path = Paths.get(dirPath);
        System.out.println("监听目录：" + dirPath);
        try {
            WatchService watcher = path.getFileSystem().newWatchService();
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
            path.register(watcher,StandardWatchEventKinds.ENTRY_DELETE);
            path.register(watcher,StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey watchKey = watcher.take();

            while (true) {
                List<WatchEvent<?>> events = watchKey.pollEvents();
                for (WatchEvent event : events) {
                    if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())){
                        System.out.println("创建文件：" + event.context().toString());
                    }else if (StandardWatchEventKinds.ENTRY_DELETE.equals(event.kind())){
                        System.out.println("删除文件：" + event.context().toString());
                    }else if (StandardWatchEventKinds.ENTRY_MODIFY.equals(event.kind())){
                        System.out.println("修改文件：" + event.context().toString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO里的内存映射
     * http://www.importnew.com/2000.html
     */
    public static void memoryMapped(){
        int mem_map_size=20*1024*1024;
        String mem_map_file="/Users/dannyhoo/data/files/memory_mapped_file.txt";
        try {
            RandomAccessFile memoryMappedFile=new RandomAccessFile(mem_map_file,"rw");

            //Mapping a file into memory
            MappedByteBuffer out =memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE,0,mem_map_size);

            //Writing into memory mapped file
            for (int i=0;i<mem_map_size;i++){
                out.put((byte)new Random().nextInt(128));
            }
            System.out.println("File "+mem_map_file+" now is "+Integer.toString(mem_map_size)+" full");

            //Read from memory mapped file
            for (int i=40;i<=50;i++){
                System.out.println((char)out.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
