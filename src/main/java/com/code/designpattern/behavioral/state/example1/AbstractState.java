package com.code.designpattern.behavioral.state.example1;

import lombok.Data;

@Data
public abstract class AbstractState {

    protected ForumAccount acc;
    protected int point;
    protected String stateName;

    public abstract void checkState(int score);

    public void downloadFile(int score) {
        System.out.println(acc.getName() + "下载文件，扣除" + score + "积分。");
        this.point -= score;
        checkState(score);
        System.out.println("剩余积分为：" + this.point + "，当前级别为：" + acc.getState().stateName + "。");
    }

    public void writeNote(int score) {
        System.out.println(acc.getName() + "发布留言" + "，增加" + score + "积分。");
        this.point += score;
        checkState(score);
        System.out.println("剩余积分为：" + this.point + "，当前级别为：" + acc.getState().stateName + "。");
    }

    public void replyNote(int score) {
        System.out.println(acc.getName() + "回复留言，增加" + score + "积分。");
        this.point += score;
        checkState(score);
        System.out.println("剩余积分为：" + this.point + "，当前级别为：" + acc.getState().stateName + "。");
    }


}