package com.code.designpattern.creational.factory.frame;

import com.code.designpattern.creational.factory.frame.factory.AbstractFactory;
import com.code.designpattern.creational.factory.frame.factory.FactoryA;
import com.code.designpattern.creational.factory.frame.factory.FactoryB;
import com.code.designpattern.creational.factory.frame.product.AbstractProduct;

/**
 * @author
 * @Title: Client
 *
 * @Description:
 *
 * @Created on 2017-06-22 22:51:14
 */
public class Client {
    public static void main(String[] args) {
        try {
            AbstractFactory factory1 = new FactoryA();
            AbstractProduct product1 = factory1.createProduct();
            AbstractFactory factory2 = new FactoryB();
            AbstractProduct product2 = factory2.createProduct();
            /*通常情况下可以用反射获取具体工厂（读取配置文件、数据库等）*/
            AbstractFactory factory3 = (AbstractFactory) Class.forName(FactoryA.class.getName()).newInstance();
            AbstractProduct product3 = factory3.createProduct();
            AbstractFactory factory4 = (AbstractFactory) Class.forName(FactoryB.class.getName()).newInstance();
            AbstractProduct product4 = factory4.createProduct();

            System.out.println("product1 is " + product1.getClass().getSimpleName());
            System.out.println("product2 is " + product2.getClass().getSimpleName());
            System.out.println("product3 is " + product3.getClass().getSimpleName());
            System.out.println("product4 is " + product4.getClass().getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
