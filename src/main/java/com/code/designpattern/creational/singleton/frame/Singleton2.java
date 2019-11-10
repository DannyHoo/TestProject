package com.code.designpattern.creational.singleton.frame;

/**
 * @author
 * @Title: Singleton2
 *
 * @Description: 懒汉模式 线程安全
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步。
 *
 * @Created on 2017-06-24 14:07:51
 */
public class Singleton2 extends AbstractSinngleton {
    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
