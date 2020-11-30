package com.code.javabasic.queue.blocking.delayqueue.demo2;

import com.alibaba.fastjson.JSON;
import com.code.javabasic.queue.blocking.delayqueue.demo2.dto.Order;
import com.code.utils.PrintUtil;

/**
 * @author danny
 * @date 2020/5/27下午12:34
 */

public class OrderCancelDelayTask<Order> extends DelayTask<Order> {

    @Override
    public void run() {
        Order order=(Order)data;
        PrintUtil.printWithTime("处理延时队列中的任务. order"+ JSON.toJSONString(order));
    }
}
