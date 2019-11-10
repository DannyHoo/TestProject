package com.code.designpattern.behavioral.strategy.example1;

public class Context {
    private Operation operation;

    public double execute(double num1, double num2) {
        return operation.execute(num1, num2);
    }

    public Context(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public Context setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }
}
