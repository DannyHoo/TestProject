# 

Spring 容器启动时，会通知所有ApplicationListener，

每个观察者实现ApplicationListener的onApplicationEvent监听方法，启动完spring容器后，会依次执行每个ApplicationListener的监听方法