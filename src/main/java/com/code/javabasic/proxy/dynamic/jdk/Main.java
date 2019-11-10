package com.code.javabasic.proxy.dynamic.jdk;

import com.code.javabasic.proxy.dynamic.HelloChServiceImpl;
import com.code.javabasic.proxy.dynamic.HelloEnServcieImpl;
import com.code.javabasic.proxy.dynamic.IHelloService;

/**
 * https://blog.csdn.net/huyuyang6688/article/details/52025353
 */
public class Main {
    public static void main(String[] args) {
        JDKProxy JDKProxy = new JDKProxy();

        IHelloService helloService = new HelloEnServcieImpl();
        IHelloService nihaoService = new HelloChServiceImpl();

        IHelloService helloServiceProxy = (IHelloService) JDKProxy.createProxyInstance(helloService);
        helloServiceProxy.sayHello("Danny");
        helloServiceProxy.sayHi("Danny");

        IHelloService nihaoServiceProxy = (IHelloService) JDKProxy.createProxyInstance(nihaoService);
        nihaoServiceProxy.sayHello("Danny");
        nihaoServiceProxy.sayHi("Danny");
    }
}
