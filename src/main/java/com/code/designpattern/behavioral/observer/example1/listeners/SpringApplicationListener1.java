package com.code.designpattern.behavioral.observer.example1.listeners;

import com.code.designpattern.behavioral.observer.example1.SpringApplicationListener;

/**
 * @date 2020/10/29下午2:57
 */
public class SpringApplicationListener1 implements SpringApplicationListener {

    @Override
    public void listen(Object object) {
        System.out.println("SpringApplicationListener1 listen");
    }
}
