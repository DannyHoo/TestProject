package com.code.designpattern.behavioral.observer.example2;

/**
 * @date 2020/10/30下午5:04
 */
public class Dog implements Observer {
    @Override
    public void response() {
        System.out.println("狗：猫来了，我不怕它");
    }
}
