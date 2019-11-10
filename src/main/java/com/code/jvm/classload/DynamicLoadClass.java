package com.code.jvm.classload;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Danny
 * @Title: DynamicLoadClass
 * @Description: 一个tomcat只启动一个JVM，也就是说3个应用都是跑在一个JVM里，之所以它们不能互相调用是因为被类加载器隔离开的。
 * Tomcat 的类加载器层次是：
 * Bootstrap
 * |
 * System
 * |
 * Common
 * /
 * Webapp1 Webapp2 ...
 * <p>
 * 每个应用的中的类分别是由Webapp1、Webapp2类加载器加载的，所以是相互不可见的。
 * @Created on 2019-02-28 23:21:55
 */
public class DynamicLoadClass {

    /**
     * 热加载 动态加载更新的类
     * 测试类加载特性：同一个类加载器无法多次加载同一个类
     * 当类的内容（比如方法）更新时，可以重新new一个类加载器去加载类，因为同一个类加载器不能多次加载同一个类
     * 该程序运行时，如果更新了被加载的类的方法并重新打包，可以重新加载并执行，mvn package时删除jar的期间可能会报java.lang.ClassNotFoundException
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:/Users/dannyhoo/github/01_projects_danny/TestProject/jar-model/target/testproject.jar")});

        while (true) {
            //URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:/Users/dannyhoo/github/01_projects_danny/TestProject/jar-model/target/testproject.jar")});

            Class<?> clazz = classLoader.loadClass("com.code.jvm.classload.LoadClassTestService");
            Object newInstance = clazz.newInstance();
            clazz.getMethod("print").invoke(newInstance);

            classLoader.close();
            Thread.sleep(5000);
        }
    }
}
