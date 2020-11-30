package com.code.javabasic.queue.blocking.delayqueue.demo1;

import com.code.utils.DateUtils;
import com.code.utils.PrintUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @date 2020/5/25下午4:53
 * https://www.cnblogs.com/barrywxx/p/8525907.html
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        DelayQueueManager delayQueueManager=new DelayQueueManager();
        Task task1=new Task("延迟5秒执行",5,DateUtils.getNowDate());
        Task task2=new Task("延迟20秒执行",20,DateUtils.getNowDate());
        Task task3=new Task("延迟5分钟执行",5*60,DateUtils.getNowDate());
        delayQueueManager.put(task1,5, TimeUnit.SECONDS);
        delayQueueManager.put(task2,20, TimeUnit.SECONDS);
        delayQueueManager.put(task3,5, TimeUnit.MINUTES);

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Task implements Runnable{
        private String param1;
        private Integer param2;
        private Date param3;

        @Override
        public void run() {
            PrintUtil.printWithTime("task executed. param1["+param1+"] param2["+param2+"] param3["+param3+"]");
        }
    }
}
