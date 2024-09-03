package com.naiteck.example.aspect.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    String value() default "";

    /**
     * 日志类型
     * @return (0:操作日志,1:登录日志,2:定时任务)
     */
    int logType() default  1;

    /**
     * 操作日志类型
     * @return (1:查询，2:添加,3:修改,4:删除)
     */
    int operationType() default 0;

}
