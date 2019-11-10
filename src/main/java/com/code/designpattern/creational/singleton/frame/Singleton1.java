package com.code.designpattern.creational.singleton.frame;

/**
 * @author
 * @Title: Singleton1
 *
 * @Description: 懒汉模式 线程不安全
 * 这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 *
 * @Created on 2017-06-24 13:58:30
 */
public class Singleton1{
    private static Singleton1 singleton1;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
