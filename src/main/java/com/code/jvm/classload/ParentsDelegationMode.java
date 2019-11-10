package com.code.jvm.classload;

import sun.misc.Launcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Danny
 * @Title: ParentsDelegationMode
 * @Description:
 * @Created on 2019-03-03 11:32:20
 */
public class ParentsDelegationMode {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        ParentClassLoader parentClassLoader=new ParentClassLoader(new URL[]{new URL("file:/Users/dannyhoo/github/01_projects_danny/TestProject/jar-model/target/testproject1.jar")});


        ClassLoader classLoader=new ClassLoader(new URL[]{new URL("file:/Users/dannyhoo/github/01_projects_danny/TestProject/jar-model/target/testproject.jar")},parentClassLoader);

        Class<?> clazz=classLoader.loadClass("com.danny.test.jar.LoadClassTestService");

        System.out.println(clazz.getClassLoader());

    }

    static class ParentClassLoader extends URLClassLoader{
        public ParentClassLoader(URL[] urls) {
            super(urls);
        }
    }

    static class ClassLoader extends URLClassLoader{
        public ClassLoader(URL[] urls, java.lang.ClassLoader parent) {
            super(urls, parent);
        }
    }
}
