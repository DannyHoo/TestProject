package com.code.jvm;

/**
 * @author Danny
 * @Title: GCLogTest
 * @Description:
 * 垃圾回收过程梳理：https://www.jianshu.com/p/00cf4615dc74
 *
 * @Created on 2019-02-26 22:41:47
 */
public class GCLogTest {
    private static final int _1M=1024*1024;

    /**
     * VM Options：-Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1M];
        allocation2=new byte[2*_1M];
        //Thread.sleep(100000);
        //System.gc();
        allocation3=new byte[2*_1M];
        allocation3=new byte[4*_1M];//出现一次Minor GC


    }
}
