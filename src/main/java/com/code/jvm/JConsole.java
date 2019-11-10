package com.code.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author huyuyang@lxfintech.com
 * @Title: JConsole
 * @Copyright: Copyright (c) 2016
 * @Description:
 *
-Xms100m
-Xmx100m
-XX:+PrintGCDetails
-XX:+PrintGCTimeStamps
-XX:+PrintGCDateStamps
-Xloggc:/Users/dannyhoo/data/jvm/gc.log
-verbose:gc
 * @Company: lxjr.com
 * @Created on 2018-07-11 14:47:44
 */
public class JConsole {

    static class OOMObject{
        public byte[] placeholder=new byte[64*1024];//64k
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> oomObjectList=new ArrayList<>();
        for (int i=0;i<num;i++){
            Thread.sleep(10);
            oomObjectList.add(new OOMObject());
        }
        //System.gc();
        System.out.println();
    }

    public static void fillHeap2(int num) throws InterruptedException {
        while (true){
            Thread.currentThread().sleep(1000);
            List<OOMObject> oomObjectList=new ArrayList<>();
            for (int i=0;i<num;i++){
                Thread.sleep(50);
                oomObjectList.add(new OOMObject());
            }
            //System.gc();
        }
    }

    public static void fillHeapWithArray(int num) throws InterruptedException {
        while(true){
            Thread.currentThread().sleep(1000);
            List<byte[]> byteList=new ArrayList<>();
            for (int i=0;i<num;i++){
                Thread.sleep(50);
                byteList.add(new byte[64*1024]);
            }
            System.gc();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        while(true){
            Thread.currentThread().sleep(1000);
            fillHeap(1000);
            System.gc();
        }
    }
}
