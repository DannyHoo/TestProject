package com.code.designpattern.behavioral.strategy.frame;

public class Main {
    public static void main(String[] args) {
        AbstractStrategy strategy=new StrategyA();
        Context context=new Context().setStrategy(strategy);
        context.doSomething();
    }
}
