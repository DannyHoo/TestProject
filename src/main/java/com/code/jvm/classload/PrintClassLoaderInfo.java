package com.code.jvm.classload;

import sun.misc.Launcher;
import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author Danny
 * @Title: PrintClassLoaderInfo
 * @Description:
 * @Created on 2019-02-28 21:54:44
 */
public class PrintClassLoaderInfo {

    public void a(Class c){

    }
    /**
     * 打印：JVM参数 查看加载class的日志 -verbose:class
     * 输出gc信息：-verbose:gc
     * 输出native调用信息：-verbose:jni
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("String 的类加载器：" + String.class.getClassLoader());
        System.out.println("DNSNameService 的类加载器" + DNSNameService.class.getClassLoader());
        System.out.println("PrintClassLoaderInfo 的类加载器" + PrintClassLoaderInfo.class.getClassLoader());

        // 启动类加载器加载路径：JAVA_HOME/lib
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        //Launcher
    }

}
