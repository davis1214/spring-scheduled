package com.miao.spring.scheduled.config;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Configuration
public class MiaoScheduledConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Method[] methods = BatchProperties.Job.class.getMethods();
        int defaultPoolSize = 3;
        int corePoolSize = 0;
        if (methods != null && methods.length > 0) {
            for (Method method : methods) {
                Scheduled annotation = method.getAnnotation(Scheduled.class);
                if (annotation != null) {
                    corePoolSize++;
                }
            }
            if (defaultPoolSize > corePoolSize)
                corePoolSize = defaultPoolSize;
        }
        List<CronTask> cronTaskList = taskRegistrar.getCronTaskList();
        cronTaskList.stream().forEach(item -> {
            // item.getTrigger().nextExecutionTime();
            Trigger trigger = item.getTrigger();
            Runnable runnable = item.getRunnable();
            if (trigger instanceof CronTrigger) {
                CronTrigger trigger1 = (CronTrigger) trigger;
                // CronSequenceGenerator trigger2 = (CronSequenceGenerator) trigger;

                // String s = trigger2.toString();
            }
            System.out.println("item = " + item.toString() + " , " + item.getExpression());
        });

        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
    }
}
