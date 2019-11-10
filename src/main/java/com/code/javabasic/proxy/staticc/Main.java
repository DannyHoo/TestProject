package com.code.javabasic.proxy.staticc;

public class Main {
    public static void main(String[] args) {
        IHelloService helloService=new HelloServiceImplProxy();
        helloService.sayHello("Danny");
    }
}
