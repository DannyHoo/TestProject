package com.code.designpattern.behavioral.state.frame;

import lombok.Data;

/**
 * @date 2020/11/4下午5:37
 */
@Data
public class Context {

    private State state;

    public void request() {
        state.doAction();
    }

}
