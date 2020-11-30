package com.code.designpattern.behavioral.observer.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/30下午5:02
 */
public abstract class Subject {
    protected List<Observer> observerList=new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public abstract void come();

}
