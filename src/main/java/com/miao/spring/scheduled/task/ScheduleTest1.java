package com.miao.spring.scheduled.task;

import com.miao.spring.scheduled.config.MiaoScheduled;
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
public class ScheduleTest1 {

    @MiaoScheduled(cron = "*/10 * * * * ?")
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("test1 执行");

        String cron = "*/10 * * * * ?";  //每10分钟执行一次
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();  //当前系统时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);   //下次执行时间
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);  //下下次执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(currentTime);
        String nextTime = sdf.format(nextTimePoint);
        String nextDoubleTme = sdf.format(nextNextTimePoint);
        System.out.println("test1 执行 - 当前系统时间为：" + time);
        System.out.println("test1 执行下次执行时间为:" + nextTime);
        System.out.println("test1 执行下下次执行时间为：" + nextDoubleTme);
    }

    @MiaoScheduled(cron = "*/15 * * * * ?")
    public void test3() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("test1 执行");

        String cron = "*/15 * * * * ?";  //每10分钟执行一次
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();  //当前系统时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);   //下次执行时间
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);  //下下次执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(currentTime);
        String nextTime = sdf.format(nextTimePoint);
        String nextDoubleTme = sdf.format(nextNextTimePoint);
        System.out.println("test3 执行 - 当前系统时间为：" + time);
        System.out.println("test3 执行下次执行时间为:" + nextTime);
        System.out.println("test3 执行下下次执行时间为：" + nextDoubleTme);
    }

}
