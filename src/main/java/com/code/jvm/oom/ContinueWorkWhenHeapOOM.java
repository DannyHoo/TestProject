package com.code.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * jvm堆内存溢出后，其他线程是否可继续工作
 */
public class ContinueWorkWhenHeapOOM {

    public static void main(String[] args) {
        new Thread(new OOMThread()).start();
        new Thread(new NormalThread()).start();
    }

    static class OOMThread implements Runnable {
        private static List<byte[]> byteList = new ArrayList<byte[]>();

        @Override
        public void run() {
            while (true) {
                byteList.add(new byte[10*1024]);
            }
        }
    }

    static class NormalThread implements Runnable {
        @Override
        public void run() {
            List<byte[]> byteList = new ArrayList<byte[]>();
            while (true) {
                //byteList.add(new byte[1024]);
                System.out.println("NormalThread is working");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
