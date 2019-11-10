package com.code.designpattern.creational.simplefactory.frame;

/**
 * @author
 * @Title: ProductFactory
 *
 * @Description:
 *
 * @Created on 2017-06-22 00:34:10
 */
public class ProductFactory {

    public static AbstractProduct getProductBySimpleName(String type) {
        if (ProductA.class.getSimpleName().equals(type)) {
            return new ProductA();
        } else if (ProductB.class.getSimpleName().equals(type)) {
            return new ProductB();
        }
        return null;
    }
}
