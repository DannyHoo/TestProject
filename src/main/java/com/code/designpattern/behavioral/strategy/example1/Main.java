package com.code.designpattern.behavioral.strategy.example1;

public class Main {
    public static void main(String[] args) {
        Context context1=new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context1.execute(10, 5));

        Context context2=new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context2.execute(10, 5));

        Context context3=new Context(new OperationMultiple());
        System.out.println("10 * 5 = " + context3.execute(10, 5));

        Context context4=new Context(new OperationDivide());
        System.out.println("10 / 5 = " + context4.execute(10, 5));
    }
}
