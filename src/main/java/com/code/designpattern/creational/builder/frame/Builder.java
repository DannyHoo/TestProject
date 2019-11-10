package com.code.designpattern.creational.builder.frame;

/**
 * @author
 * @Title: Builder
 *
 * @Description:
 *
 * @Created on 2017-09-14 17:52:51
 * 抽象建造者类中定义了产品的创建方法和返回方法
 */
public abstract class Builder {

    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}
