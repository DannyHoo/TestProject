package com.code.designpattern.behavioral.strategy.example1;

public class OperationSubstract implements Operation {
    @Override
    public double execute(double num1, double num2) {
        return num1-num2;
    }
}
