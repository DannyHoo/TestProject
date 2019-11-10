package com.code.javabasic.proxy.dynamic;

public class HelloEnServcieImpl implements IHelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello ! " + name);
    }

    @Override
    public void sayHi(String name) {
        System.out.println("Hi ! " + name);
    }

}
