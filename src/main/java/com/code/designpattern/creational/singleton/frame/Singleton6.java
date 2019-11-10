package com.code.designpattern.creational.singleton.frame;

/**
 * @author
 * @Title: Singleton6
 *
 * @Description: 双重校验锁
 * 第二种线程安全的懒汉模式的升级版
 *
 * @Created on 2017-06-24 14:44:51
 */
public class Singleton6 extends AbstractSinngleton {
    private volatile static Singleton6 singleton6;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                singleton6 = new Singleton6();
            }
        }
        return singleton6;
    }
}
