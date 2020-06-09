package com.miao.spring.scheduled.event;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(scheduledEvent.getCron());
        Date currentTime = new Date();  //当前系统时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);   //下次执行时间
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);  //下下次执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nextTime = sdf.format(nextTimePoint);
        String nextDoubleTme = sdf.format(nextNextTimePoint);

        scheduledEvent.setNextTime(nextTime);
        scheduledEvent.setNextNextTime(nextDoubleTme);

        log.info("Subscribed scheduledEvent - {}", scheduledEvent);
    }

}
