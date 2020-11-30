package com.code.designpattern.behavioral.state.frame;

/**
 * @date 2020/11/4下午5:42
 */
public class Main {
    public static void main(String[] args) {
        Context context=new Context();
        context.setState(new ConcreteStateA());
        context.request();
        context.request();
        context.request();
    }
}
