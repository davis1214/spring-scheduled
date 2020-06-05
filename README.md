## 基于Spring scheduled的监控

> 单机节点的spring调度还是很好用的，简单方便，但缺乏监控能力

### 实现原理
1. 重新定义spring的scheduled的注解（`MiaoScheduled`）
2. 在任务执行后，增加任务执行状态的事件。
3. 在`ScheduledEventSubscriber`中增加对任务的执行状态的监听

### 参考示例
`com.miao.spring.scheduled.task.ScheduleTest1.test1`



