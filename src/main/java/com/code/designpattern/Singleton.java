package com.code.designpattern;

public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}

    public static Singleton getInstance(){
        //先判断 singleton是否是null，如果为null再进入，否则每次获取都会加锁影响性能
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
