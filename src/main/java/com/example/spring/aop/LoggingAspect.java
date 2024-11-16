package com.example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 17:06
 */
@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(* com.example.spring.aop.*.*(..))")
    @Before("execution(* com.example.spring.aop.MyService.*(..))")
    public void logBeforeMethod() {
        System.out.println("Method execution starts before...");
    }

//    @Around("execution(* com.example.spring.aop.*(..))")
    @Around("execution(* com.example.spring.aop.MyService.performTask(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        System.out.println("After method: " + joinPoint.getSignature());
        return result;
    }
}
