package com.code.designpattern.behavioral.observer.frame;

/**
 * @date 2020/9/11上午10:41
 */
public class Main {
    public static void main(String[] args) {
        Observer observer1=new ConcreteObserver("Observer1");
        Observer observer2=new ConcreteObserver("Observer2");
        Observer observer3=new ConcreteObserver("Observer3");

        ConcreteSubject concreteSubject=new ConcreteSubject();
        concreteSubject.addObserver(observer1);
        concreteSubject.addObserver(observer2);
        concreteSubject.addObserver(observer3);

        concreteSubject.notify("Welcome to our home.");

    }
}
