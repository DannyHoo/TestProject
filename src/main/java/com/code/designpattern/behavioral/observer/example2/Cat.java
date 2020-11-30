package com.code.designpattern.behavioral.observer.example2;

/**
 * @date 2020/10/30下午5:07
 */
public class Cat extends Subject {

    @Override
    public void come() {
        observerList.stream().forEach(observer -> {
            observer.response();
        });
    }
}
