package com.example.demo.retry.aspect;

import com.example.demo.retry.annotation.Retryable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Description: 重试机制aop
 *
 * @author Zeti
 * @date 2020/8/21 10:50 上午
 */
@Aspect
@Component
public class RetryAspect {

    @Pointcut("execution(* com.example.demo.retry..*(..))) &&" +
            " @@annotation(com.example.demo.retry.annotation.Retryable)")
    public void retryPointcut() {
    }


    @Around("retryPointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = getCurrentMethod(point);
        Retryable retryable = method.getAnnotation(Retryable.class);

        int maxAttempts = retryable.maxAttempts();

        if (maxAttempts<=1) {
            return point.proceed();
        }

        //2. 异常处理
        int frequency = 0;
        final Class<? extends Throwable> exceptionClass = retryable.value();
        while (frequency < maxAttempts) {
            try {
                return point.proceed();
            } catch (Throwable e) {
                // 超过最大重试次数 or 不属于当前处理异常
                if (!e.getClass().isAssignableFrom(exceptionClass)) {
                    throw new Throwable(e); // todo
                }
            } finally {
                frequency++;
            }
        }
        return null;
    }


    private Method getCurrentMethod(ProceedingJoinPoint point) {

        try {
            Object target = point.getTarget();
            Class<?> aClass = target.getClass();

            Signature signature = point.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;

            return aClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
