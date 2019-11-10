package com.code.designpattern.creational.singleton.example;

public class Singleton1 {
    private static volatile Singleton1 singleton1;

    public static Singleton1 newInstance(){
        if (singleton1==null){
            synchronized (Singleton1.class){
                if (singleton1==null){
                    singleton1=new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
