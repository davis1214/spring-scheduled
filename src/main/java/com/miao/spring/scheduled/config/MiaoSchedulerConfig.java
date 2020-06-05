package com.miao.spring.scheduled.config;

import com.miao.spring.scheduled.event.EventBusCenter;
import com.miao.spring.scheduled.event.ScheduledEventSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Component
@ConditionalOnExpression("${scheduler.enable:true}")
public class MiaoSchedulerConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    ScheduledEventSubscriber scheduledEventSubscriber;

    @Bean
    public MiaoScheduledBeanPostProcessor scheduledAnnotationProcessor() {
        EventBusCenter.register(scheduledEventSubscriber);

        return new MiaoScheduledBeanPostProcessor();
    }

}
