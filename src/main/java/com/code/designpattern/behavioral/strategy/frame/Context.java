package com.code.designpattern.behavioral.strategy.frame;

public class Context {
    private AbstractStrategy strategy;

    public void doSomething() {
        strategy.doSomething();
    }

    public AbstractStrategy getStrategy() {
        return strategy;
    }

    public Context setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
        return this;
    }
}
