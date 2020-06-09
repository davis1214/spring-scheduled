package com.miao.spring.scheduled.config;

import com.miao.spring.scheduled.event.EventBusCenter;
import com.miao.spring.scheduled.event.ScheduledEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Slf4j
public class MiaoScheduledMethodRunnable implements Runnable {

    private final Object target;

    private final Method method;

    public MiaoScheduledMethodRunnable(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public MiaoScheduledMethodRunnable(Object target, String methodName) throws NoSuchMethodException {
        this.target = target;
        this.method = target.getClass().getMethod(methodName);
    }

    public Object getTarget() {
        return this.target;
    }

    public Method getMethod() {
        return this.method;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        try {
            String task = this.getMethod().getDeclaringClass().getName() + "." + this.getMethod().getName();
            log.info(String.format("scheduled task %s start", task));
            ReflectionUtils.makeAccessible(this.method);
            this.method.invoke(this.target);
            log.info(String.format("scheduled task %s end", task));

            ScheduledEvent scheduledEvent = new ScheduledEvent();
            scheduledEvent.setTaskName(task);
            scheduledEvent.setCurrentTime(sdf.format(new Date()));
            MiaoScheduled declaredAnnotation = this.getMethod().getDeclaredAnnotation(MiaoScheduled.class);
            if (declaredAnnotation != null) {
                scheduledEvent.setCron(declaredAnnotation.cron());
            }
            EventBusCenter.post(scheduledEvent);
        } catch (InvocationTargetException ex) {
            ReflectionUtils.rethrowRuntimeException(ex.getTargetException());
        } catch (IllegalAccessException ex) {
            throw new UndeclaredThrowableException(ex);
        }
    }

    @Override
    public String toString() {
        return this.method.getDeclaringClass().getName() + "." + this.method.getName();
    }

}
