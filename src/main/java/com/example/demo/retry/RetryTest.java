package com.example.demo.retry;

import com.example.demo.retry.annotation.Retryable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/21 11:26 上午
 */
public class RetryTest {
    private static final Logger logger = LoggerFactory.getLogger(RetryTest.class);

    @Retryable(maxAttempts = 5, value = Exception.class)
    public void fiveTimes() {
        logger.info("fiveTimes called!");
        throw new IllegalArgumentException();
    }

}
