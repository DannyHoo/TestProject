package com.code.designpattern.creational.prototype.example1;

/**
 * @author
 * @Title: Client
 *
 * @Description:
 *
 * @Created on 2017-09-20 11:29:00
 */
public class Client {

    public static void main(String[] args) {

        Mouth mouth = new Mouth().setTeethCount(24);
        Face face = new Face().setMouth(mouth);
        Head head = new Head().setFace(face);
        Body body = new Body().setHead(head);

        Body cloneBody = null;
        try {
            cloneBody = body.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(body);
        System.out.println(cloneBody);
    }
}
