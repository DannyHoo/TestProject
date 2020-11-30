package com.code.designpattern.behavioral.observer.example2;

/**
 * @date 2020/10/30下午5:03
 */
public class Mouse implements Observer {

    @Override
    public void response() {
        System.out.println("鼠：猫来了，好怕怕呀");
    }

}
