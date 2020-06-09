package com.miao.spring.scheduled.event;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Configuration
@Slf4j
public class ScheduledEventSubscriber {

    @Subscribe
    public void subscribeScheduledEvent(ScheduledEvent scheduledEvent) {
        log.info("scheduledEvent - {}", scheduledEvent);
    }

}
