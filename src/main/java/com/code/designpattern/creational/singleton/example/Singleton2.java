package com.code.designpattern.creational.singleton.example;

/**
 * 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 * https://www.cnblogs.com/zhaoyan001/p/6365064.html
 */
public class Singleton2 {

    public static void main(String[] args) {
        Singleton2 singleton2=null;
        singleton2=newInstance();
        System.out.println(singleton2);
    }
    static class SingletonInstance {
        public static final Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 newInstance() {
        return SingletonInstance.singleton2;
    }
}
