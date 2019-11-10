package com.code.designpattern.creational.builder.frame;

/**
 * @author
 * @Title: ConcreteBuilder
 *
 * @Description:
 *
 * @Created on 2017-09-14 17:55:13
 */
public class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("");
        System.out.println("buildPartA");
    }

    public void buildPartB() {
        product.setPartB("buildPartB");
        System.out.println("buildPartB");
    }

    public void buildPartC() {
        product.setPartC("buildPartC");
        System.out.println("buildPartC");
    }
}
