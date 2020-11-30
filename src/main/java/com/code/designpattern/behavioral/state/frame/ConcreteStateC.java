package com.code.designpattern.behavioral.state.frame;

/**
 * @date 2020/11/4下午5:37
 */
public class ConcreteStateC extends State {

    @Override
    public void doAction() {
        System.out.println("ConcreteStateC.doAction");
        System.out.println("已达到最终状态");
    }

}
