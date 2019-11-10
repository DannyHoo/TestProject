package com.code.thread.volatiletest;

/**
 * @author Danny
 * @Title: VolatileTest
 * @Description: volatile适用场景
 * @Created on 2018-09-18 14:48:12
 */
public class VolatileTest {

    private volatile boolean isFinished = false;
    private String content;

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        WriterThread writerThread = volatileTest.new WriterThread();
        ReaderThread readerThread = volatileTest.new ReaderThread();
        writerThread.start();
        readerThread.start();
    }

    class WriterThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("写的内容为：" + (content = "Hello World!"));
            isFinished = true;
        }
    }

    class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!isFinished) {
                //有下面这句时，即时不加volatile也会停止 ，即添加这句话跟家volatile有一样的效果(执行输出加大了读取变量的时间间隔，读取频率不是很高的情况，虚拟机会从主存中读取最新的变量)
                //System.out.println("等待写入……");
            }
            System.out.println("读的内容为：" + content);
        }
    }
}
