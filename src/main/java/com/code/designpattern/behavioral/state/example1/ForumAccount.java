package com.code.designpattern.behavioral.state.example1;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ForumAccount {

    private AbstractState state;
    private String name;

    public ForumAccount(String name) {
        this.name = name;
        this.state = new PrimaryState(this);
        System.out.println(this.name + "注册成功！");
        System.out.println("---------------------------------------------");
    }

    public void downloadFile(int score) {
        state.downloadFile(score);
    }

    public void writeNote(int score) {
        state.writeNote(score);
    }

    public void replyNote(int score) {
        state.replyNote(score);
    }
}