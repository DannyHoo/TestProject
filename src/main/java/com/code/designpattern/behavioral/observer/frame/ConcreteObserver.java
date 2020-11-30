package com.code.designpattern.behavioral.observer.frame;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @date 2020/9/11上午10:28
 */
@Slf4j
@AllArgsConstructor
public class ConcreteObserver implements Observer {

    private String name;
    @Override
    public void listen(String message) {
        log.info("{} received message:{}",name,message);
    }
}
