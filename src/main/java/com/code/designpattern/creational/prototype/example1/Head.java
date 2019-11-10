package com.code.designpattern.creational.prototype.example1;

/**
 * @author
 * @Title: Head
 *
 * @Description:
 *
 * @Created on 2017-09-20 11:18:03
 */
public class Head implements Cloneable {
    private Face face;

    public Head clone() throws CloneNotSupportedException {
        Head head = (Head)super.clone();
        return head;
    }

    public Face getFace() {
        return face;
    }

    public Head setFace(Face face) {
        this.face = face;
        return this;
    }
}
