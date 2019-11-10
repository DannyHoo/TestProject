package com.code.javabasic.proxy.dynamic.cglib;


import com.code.javabasic.proxy.dynamic.HelloEnServcieImpl;

public class Main {
    public static void main(String[] args) {
        CglibProxy cglibProxy=new CglibProxy();
        HelloEnServcieImpl helloEnServcie=(HelloEnServcieImpl)cglibProxy.getProxy(HelloEnServcieImpl.class);
        helloEnServcie.sayHello("Danny");
        helloEnServcie.sayHi("Danny");
    }
}
