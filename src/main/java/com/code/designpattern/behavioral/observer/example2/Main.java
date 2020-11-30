package com.code.designpattern.behavioral.observer.example2;

/**
 * @date 2020/10/30下午5:10
 */
public class Main {
    public static void main(String[] args) {
        Mouse mouse=new Mouse();
        Dog dog=new Dog();
        Cat cat=new Cat();

        cat.attach(mouse);
        cat.attach(dog);

        cat.come();
    }
}
