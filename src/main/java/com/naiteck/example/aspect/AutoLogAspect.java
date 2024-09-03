package com.naiteck.example.aspect;

import com.naiteck.example.aspect.annotation.AutoLog;
import com.naiteck.example.utils.SpringContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AutoLogAspect {

    @Pointcut("@annotation(com.naiteck.example.aspect.annotation.AutoLog)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();

        Object result = point.proceed();

        long time = System.currentTimeMillis() - beginTime;

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint point,long time,Object data){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();

    }
}
