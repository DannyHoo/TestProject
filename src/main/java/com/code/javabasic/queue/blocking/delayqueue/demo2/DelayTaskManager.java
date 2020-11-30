package com.code.javabasic.queue.blocking.delayqueue.demo2;

import com.code.javabasic.queue.blocking.delayqueue.demo2.dto.Order;
import com.code.utils.DateUtils;
import com.code.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author danny
 * @date 2020/5/27下午12:28
 */
@Slf4j
public class DelayTaskManager {
    private static DelayQueue<DelayTask> delayQueue=new DelayQueue<>();
    private ExecutorService executor=new ThreadPoolExecutor(10,10,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());


    //系统启动，初始化【延迟任务】到本地【延迟队列】
    public static void main(String[] args) {
        DelayTaskManager delayTaskManager=new DelayTaskManager();

        DelayTask delayTask1=new OrderCancelDelayTask();
        Order order1=new Order().setOrderNo("123").setBeginTime(DateUtils.addSeconds(DateUtils.getNowDate(),10));
        delayTask1.setData(order1);
        delayTask1.setExecuteTime(order1.getBeginTime());
        delayQueue.add(delayTask1);

        DelayTask delayTask2=new OrderCancelDelayTask();
        Order order2=new Order().setOrderNo("123").setBeginTime(DateUtils.addSeconds(DateUtils.getNowDate(),20));
        delayTask2.setData(order2);
        delayTask2.setExecuteTime(order2.getBeginTime());
        delayQueue.add(delayTask2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DelayTask delayTask3=new OrderCancelDelayTask();
                Order order3=new Order().setOrderNo("123").setBeginTime(DateUtils.addSeconds(DateUtils.getNowDate(),20));
                delayTask3.setData(order3);
                delayTask3.setExecuteTime(order3.getBeginTime());
                delayQueue.add(delayTask3);
                PrintUtil.printWithTime("30秒后又加了一个任务");
            }
        }).start();

        delayTaskManager.executeDelayTasks();


    }

    public void executeDelayTasks(){
        for (;;){
            Map<Thread,StackTraceElement[]> map=Thread.getAllStackTraces();
            PrintUtil.printWithTime("当前存活线程数量："+map.size());
            int taskNum=delayQueue.size();
            PrintUtil.printWithTime("当前延时任务数量："+taskNum);

            try{
                DelayTask delayTask=delayQueue.take();
                if (delayTask!=null){
                    executor.execute(delayTask);
                }
            }catch (Exception e){
                log.error("executeDelayTasks error.",e);
            }
        }
    }
}
