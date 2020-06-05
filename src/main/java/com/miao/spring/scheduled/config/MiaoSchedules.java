package com.miao.spring.scheduled.config;

import java.lang.annotation.*;

/**
 * @param
 * @Author: DaviHe
 * @Description:
 * @Date: Created in 2020/05/19
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MiaoSchedules {
    MiaoScheduled[] value();
}
