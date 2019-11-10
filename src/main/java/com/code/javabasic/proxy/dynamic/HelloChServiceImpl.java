package com.code.javabasic.proxy.dynamic;

public class HelloChServiceImpl implements IHelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("你好 ！ " +name);
    }

    @Override
    public void sayHi(String name) {
        System.out.println("嗨 ！ " +name);
    }

}
