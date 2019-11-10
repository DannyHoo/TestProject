package com.code.designpattern.creational.singleton.frame;

/**
 * @author
 * @Title: Singleton4
 *
 * @Description: 饿汉模式
 * 和第三种饿汉模式差不多，都是在类初始化即实例化实例
 *
 * @Created on 2017-06-24 14:13:15
 */
public class Singleton4 {
    private static Singleton4 singleton4;

    static {
        singleton4 = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return singleton4;
    }
}
