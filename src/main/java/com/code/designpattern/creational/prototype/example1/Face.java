package com.code.designpattern.creational.prototype.example1;

/**
 * @author
 * @Title: Face
 *
 * @Description:
 *
 * @Created on 2017-09-20 11:17:59
 */
public class Face {
    private Mouth mouth;

    public Mouth getMouth() {
        return mouth;
    }

    public Face setMouth(Mouth mouth) {
        this.mouth = mouth;
        return this;
    }
}
