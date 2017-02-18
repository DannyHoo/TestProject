package com.danny.test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang@lxfintech.com
 * @Title: Scheduler
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-08 13:05:26
 */
@Component
public class Scheduler {

    @Scheduled(cron="0/5 * *  * * ? ")   //每10秒执行一次
    public void timerTest(){
        System.out.println("timerTest");
    }
}
