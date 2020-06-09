package com.miao.spring.scheduled.event;

import lombok.Data;
import lombok.ToString;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@ToString
@Data
public class ScheduledEvent {

    private String taskName;
    private String currentTime;
    private String nextTime;
    private String nextNextTime;
    private String cron;

}
