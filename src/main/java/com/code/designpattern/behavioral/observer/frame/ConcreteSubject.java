package com.code.designpattern.behavioral.observer.frame;

/**
 * @date 2020/9/11上午10:39
 */
public class ConcreteSubject extends Subject {

    @Override
    public void notify(String message) {
        for (Observer observer : observerList) {
            observer.listen(message);
        }
    }

}
