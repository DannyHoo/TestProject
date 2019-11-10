package com.code.javabasic.proxy.staticc;

public class HelloServiceImplProxy implements IHelloService {
    private IHelloService iHelloService=new HelloServcieImpl();

    @Override
    public void sayHello(String name) {
        doBefore();
        iHelloService.sayHello(name);
        doAfter();
    }

    private void doBefore(){
        System.out.println("before");
    }

    private void doAfter(){
        System.out.println("after");
    }
}
