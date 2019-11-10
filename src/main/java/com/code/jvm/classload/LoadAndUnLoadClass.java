package com.code.jvm.classload;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Danny
 * @Title: LoadAndUnLoadClass
 * @Description: tomcat 动态更新 jsp 的原理就是，文件变更之后，重新用新的类加载器去加载jsp对应的class
 * @Created on 2019-02-28 22:55:52
 */

public class LoadAndUnLoadClass {

    /**
     * -verbose:class
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        while (true) {
            try {
                Thread.sleep(2000);
                URL[] urls = new URL[]{new URL("file:/Users/dannyhoo/Downloads/04_JavaProjects/01_GitHub/01_projects_danny/TestProject/jar-model/target/testproject.jar")};

                //创建类加载器
                URLClassLoader classLoader = new URLClassLoader(urls);

                //这时 com.danny.test.jar.LoadClassTestService 会被加载（Load）
                Class<?> clazz = classLoader.loadClass("com.danny.test.jar.LoadClassTestService");

                Object newInstance = clazz.newInstance();
                clazz.getMethod("print").invoke(newInstance);

                //某个类卸载的两个前提条件：1、类的对象被gc 2、加载该类的类加载器被gc
                newInstance = null;
                classLoader = null;

                System.gc();

                //这时 com.danny.test.jar.LoadClassTestService 会被卸载（Unload）
            } catch (Exception e) {

            }
        }
    }
}
