package com.example.spring_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution (* com.example.spring_aop.service.JobService.getJob(..)) || execution (* com.example.spring_aop.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called : {}", jp.getSignature().getName());
    }

    @After("execution (* com.example.spring_aop.service.JobService.getJob(..)) || execution (* com.example.spring_aop.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method executed : {}", jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.example.spring_aop.service.JobService.getJob(..)) || execution (* com.example.spring_aop.service.JobService.updateJob(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method has some issues : {}", jp.getSignature().getName());
    }

    @AfterReturning("execution (* com.example.spring_aop.service.JobService.getJob(..)) || execution (* com.example.spring_aop.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method executed successfully : {}", jp.getSignature().getName());
    }
}
