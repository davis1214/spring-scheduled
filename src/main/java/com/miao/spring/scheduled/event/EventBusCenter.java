package com.miao.spring.scheduled.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
public class EventBusCenter {

    private final static EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));

    private EventBusCenter() {
    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public synchronized static void register(Object obj) {
        eventBus.register(obj);
    }

    public synchronized static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public synchronized static void post(Object obj) {
        eventBus.post(obj);
    }

}
