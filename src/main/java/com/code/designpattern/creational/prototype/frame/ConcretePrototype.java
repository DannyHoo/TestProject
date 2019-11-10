package com.code.designpattern.creational.prototype.frame;

import java.util.Date;

/**
 * @author
 * @Title: ConcretePrototype
 *
 * @Description:
 *
 * @Created on 2017-09-20 10:08:25
 *
 * 如果原型模式中的数组、容器对象、引用对象作为成员变量被finali修饰时，
 * 无法对它们单独clone，因为final修饰的变量需要初始化，不能重新赋值。
 */
public class ConcretePrototype extends Prototype {

    private Integer id;
    private String name;
    private Date birthday;

    public ConcretePrototype(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public ConcretePrototype setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConcretePrototype setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ConcretePrototype setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
}
