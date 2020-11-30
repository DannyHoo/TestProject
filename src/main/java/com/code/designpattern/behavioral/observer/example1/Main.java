package com.code.designpattern.behavioral.observer.example1;

import com.code.designpattern.behavioral.observer.example1.listeners.SpringApplicationListener1;
import com.code.designpattern.behavioral.observer.example1.listeners.SpringApplicationListener2;
import com.code.designpattern.behavioral.observer.example1.listeners.SpringApplicationListener3;

/**
 * @date 2020/10/29下午2:54
 */
public class Main {
    public static void main(String[] args) {
        // Spring 容器启动 实例化Bean
        SpringApplication springApplication=new SpringApplication();

        // 获取所有SpringApplicationListener的实例化对象，添加到观察者列表
        SpringApplicationListener springApplicationListener1=new SpringApplicationListener1();
        SpringApplicationListener springApplicationListener2=new SpringApplicationListener2();
        SpringApplicationListener springApplicationListener3=new SpringApplicationListener3();
        springApplication.attach(springApplicationListener1);
        springApplication.attach(springApplicationListener2);
        springApplication.attach(springApplicationListener3);

        // 通知所有观察者
        springApplication.notify("Spring容器初始化完成");

    }
}
