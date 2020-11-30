package com.code.designpattern.behavioral.observer.frame;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/9/11上午10:24
 */
public abstract class Subject {

    protected List<Observer> observerList=new ArrayList<>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer){
        observerList.remove(observer);
    }

    public abstract void notify(String message);

}
