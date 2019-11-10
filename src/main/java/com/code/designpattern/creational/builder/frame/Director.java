package com.code.designpattern.creational.builder.frame;

/**
 * @author
 * @Title: Director
 *
 * @Description:
 *
 * @Created on 2017-09-14 17:50:03
 * 建造者模式的结构中还引入了一个指挥者类Director,该类的作用主要有两个:
 * 一方面它隔离了客户与生产过程;
 * 另一方面它负责控制产品的生成过程。
 * 指挥者针对抽象建造者编 程,客户端只需要知道具体建造者的类型,
 * 即可通过指挥者类调用建造者的相关方法,返回一个完整的产品对象。
 */
public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder=builder;
    }
    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
