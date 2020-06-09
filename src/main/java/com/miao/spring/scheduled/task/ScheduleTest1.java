package com.miao.spring.scheduled.task;

import com.miao.spring.scheduled.config.MiaoScheduled;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Adam
 * @Description: //TODO
 * @Title: ScheduleTest1
 * @ProjectName demo_schedule
 * @date 2019/6/15 11:52
 */
@Component
@Slf4j
public class ScheduleTest1 {

    @MiaoScheduled(cron = "*/10 * * * * ?")
    public void test1() throws InterruptedException {
        log.info("test1 执行 - start");
        Thread.sleep(RandomUtils.nextInt(4) * 1000L);
        log.info("test1 执行 - end");
    }

    @MiaoScheduled(cron = "*/15 * * * * ?")
    public void test3() throws InterruptedException {
        log.info("test3 执行 - start");
        Thread.sleep(RandomUtils.nextInt(3) * 1000L);
        log.info("test3 执行 - end");
    }

}
