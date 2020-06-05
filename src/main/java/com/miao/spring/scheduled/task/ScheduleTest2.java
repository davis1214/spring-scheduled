package com.miao.spring.scheduled.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTest2 {

    @Scheduled(cron = "*/20 * * * * ?")
    public void test1() {

        System.out.println("test2 执行");

        String cron = "*/20 * * * * ?";  //每10分钟执行一次
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();  //当前系统时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);   //下次执行时间
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);  //下下次执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(currentTime);
        String nextTime = sdf.format(nextTimePoint);
        String nextDoubleTme = sdf.format(nextNextTimePoint);
        System.out.println("test2 执行 - 当前系统时间为：" + time);
        System.out.println("test2 执行下次执行时间为:" + nextTime);
        System.out.println("test2 执行下下次执行时间为：" + nextDoubleTme);
        System.out.println("\n");


    }

}
