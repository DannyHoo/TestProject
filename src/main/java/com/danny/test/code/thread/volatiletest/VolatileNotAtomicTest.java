package com.danny.test.code.thread.volatiletest;

/**
 * @author Danny
 * @Title: VolatileNotAtomicTest
 * @Description:
 * 原子操作：
 * 原子操作是不可分割的，在执行完毕不会被任何其它任务或事件中断，分为两种情况（两种都应该满足）
（1） 在单线程中， 能够在单条指令中完成的操作都可以认为是" 原子操作"，因为中断只能发生于指令之间。
（2） 在多线程中，不能被其它进程（线程）打断的操作就叫原子操作。
 * @Created on 2018-09-10 17:14:34
 */
public class VolatileNotAtomicTest {
    private static volatile int num=0;

    private static final int count=1000000;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<count;i++){
                    num++;
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<count;i++){
                    num++;
                }
            }
        });
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<count;i++){
                    num++;
                }
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        thread.join();
        thread2.join();
        thread3.join();

        System.out.println("最终计算结果："+num);
    }


}
