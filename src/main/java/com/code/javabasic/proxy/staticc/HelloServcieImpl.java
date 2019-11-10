package com.code.javabasic.proxy.staticc;

public class HelloServcieImpl implements IHelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello ! " +name);
    }

}
