package com.example.demo.retry.annotation;

import java.lang.annotation.*;

/**
 * Description: 重试
 *
 * @author Zeti
 * @date 2020/8/21 10:45 上午
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retryable {

    /**
     * Maximum number of retries
     *
     * @return the maximum number of attempts (including the first failure), defaults to 3
     */
    int maxAttempts() default 3;

    /**
     * Exception type that are retryable.
     *
     * @return exception type to retry
     */
    Class<? extends Throwable> value() default RuntimeException.class;

}
