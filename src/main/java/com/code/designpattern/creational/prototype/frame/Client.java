package com.code.designpattern.creational.prototype.frame;

import java.util.Date;

/**
 * @author
 * @Title: Client
 *
 * @Description:
 *
 * @Created on 2017-09-20 10:09:46
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype=new ConcretePrototype(1,"danny",new Date());
        Prototype prototype=concretePrototype.clone();
        int hashcode1=concretePrototype.hashCode();
        int hashcode2=prototype.hashCode();
        System.out.println();
    }
}
