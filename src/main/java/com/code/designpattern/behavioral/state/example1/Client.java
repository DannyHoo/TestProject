package com.code.designpattern.behavioral.state.example1;

public class Client {

    public static void main(String args[]) {
        System.out.println("开始");
        ForumAccount account = new ForumAccount("张三");
        account.writeNote(20);
        System.out.println("--------------------------------------");
        account.downloadFile(20);
        System.out.println("--------------------------------------");
        account.replyNote(100);
        System.out.println("--------------------------------------");
        account.writeNote(40);
        System.out.println("--------------------------------------");
        account.downloadFile(80);
        System.out.println("--------------------------------------");
        account.downloadFile(150);
        System.out.println("--------------------------------------");
        account.writeNote(1000);
        System.out.println("--------------------------------------");
        account.downloadFile(80);
        System.out.println("--------------------------------------");
    }

}