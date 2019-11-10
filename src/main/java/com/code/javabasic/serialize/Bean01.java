package com.code.javabasic.serialize;

import java.io.Serializable;

/**
 * Serializable 是java的序列化技术，最简单的使用方式为在需要序列化的class增加implements Serializable，
 * 并增加一个唯一个序列化id： private static final long serialVersionUID = 1L; 默认方式最好直接设置为1L,
 * 因为java  sdk会自动进行hash计算，并生成唯一的UID值。手动设置serialVersionUID的好处是当前class如果改变了成员变量，
 * 比如增加或者删除之后，这个UID是不改变的，那么反序列化就不会失败；自动设置则在改变了成员变量之后就会重新计算获得新的UID，从而导致失败。
 * https://blog.csdn.net/hacker_crazy/article/details/80840868
 */
public class Bean01 implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public Bean01 setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bean01 setName(String name) {
        this.name = name;
        return this;
    }
}
