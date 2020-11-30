package com.code.javabasic.queue.blocking.delayqueue.demo2.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author danny
 * @date 2020/5/27下午12:38
 */
@Data
@Accessors(chain = true)
public class Order {
    private String orderNo;
    private Date beginTime;
}
