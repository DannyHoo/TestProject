
### 常见的负载均衡算法

- 轮询法（Round Robin）
- 加权轮询法（Weight Round Robin）
- 随机法（Random）
- 加权随机法（Weight Random）
- 平滑加权轮询法（Smooth Weight Round Robin）
- 源地址哈希法（Hash）
- 最小连接数法（Least Connections）


### 总结

1. 加权轮询和加权随机的区别？

加权轮询可以做到对权重控制绝对的精确；加权随机可以做到一定概率的精确，数量越大越接近预定的比例
加权轮询在某一时间点对某一个服务器压力较大；随机可以一定程度上平衡服务器压力