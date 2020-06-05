package com.miao.spring.scheduled.event;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
public class ScheduledEvent {

    String taskName;
    String currentTime;
    String nextTime;
    String nextNextTime;

    String cron;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public String getNextNextTime() {
        return nextNextTime;
    }

    public void setNextNextTime(String nextNextTime) {
        this.nextNextTime = nextNextTime;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "ScheduledEvent{" +
                "taskName='" + taskName + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", nextTime='" + nextTime + '\'' +
                ", nextNextTime='" + nextNextTime + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
