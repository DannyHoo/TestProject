package com.code.jvm;

/**
 * @Title: JVMView
 * @Description:
 * https://blog.csdn.net/rickyit/article/details/53895060
 * @Created on 2018-06-08 16:10:33
 */
public class JVMView {
    public static void main(String[] args) {
        System.out.println("JVM可获得最大内存："+ Runtime.getRuntime().maxMemory()/(1024*1024)+"M");
        System.out.println("JVM已获得最大内存："+ Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
        System.out.println("JVM获得的空闲内存："+ Runtime.getRuntime().freeMemory()/(1024*1024)+"M");
    }
}
