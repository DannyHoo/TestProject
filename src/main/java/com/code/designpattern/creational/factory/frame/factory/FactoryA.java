package com.code.designpattern.creational.factory.frame.factory;


import com.code.designpattern.creational.factory.frame.product.AbstractProduct;
import com.code.designpattern.creational.factory.frame.product.ProductA;

/**
 * @author
 * @Title: FactoryA
 *
 * @Description:
 *
 * @Created on 2017-06-22 22:49:16
 */
public class FactoryA extends AbstractFactory {
    public AbstractProduct createProduct() {
        return new ProductA();
    }
}
