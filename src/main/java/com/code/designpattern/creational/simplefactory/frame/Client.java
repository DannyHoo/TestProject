package com.code.designpattern.creational.simplefactory.frame;

/**
 * @author
 * @Title: Client
 *
 * @Description:
 *
 * @Created on 2017-06-22 00:36:28
 */
public class Client {
    public static void main(String[] args) {
        /*获取ProductA的实例*/
        AbstractProduct product1=ProductFactory.getProductBySimpleName(ProductA.class.getSimpleName());
        product1.doSomething();

        /*获取ProductB的实例*/
        AbstractProduct product2=ProductFactory.getProductBySimpleName(ProductB.class.getSimpleName());
        product2.doSomething();
    }
}
