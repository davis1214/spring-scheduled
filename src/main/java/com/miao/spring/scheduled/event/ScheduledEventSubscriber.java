package com.miao.spring.scheduled.event;

import com.google.common.eventbus.Subscribe;
import org.springframework.context.annotation.Configuration;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Configuration
public class ScheduledEventSubscriber {

    @Subscribe
    public void subscribeScheduledEvent(ScheduledEvent scheduledEvent) {
        System.out.println("-->scheduledEvent = " + scheduledEvent);
    }

}
