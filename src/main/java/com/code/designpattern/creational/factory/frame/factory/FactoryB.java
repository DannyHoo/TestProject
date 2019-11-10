package com.code.designpattern.creational.factory.frame.factory;


import com.code.designpattern.creational.factory.frame.product.AbstractProduct;
import com.code.designpattern.creational.factory.frame.product.ProductB;

/**
 * @author
 * @Title: FactoryB
 *
 * @Description:
 *
 * @Created on 2017-06-22 22:49:25
 */
public class FactoryB extends AbstractFactory {
    public AbstractProduct createProduct() {
        return new ProductB();
    }
}
