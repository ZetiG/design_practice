package com.example.demo.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/7/29 10:01 上午
 */
public class AtomicInteger_Demo implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AtomicInteger_Demo.class);

    private String name;

    private AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger_Demo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AtomicInteger_Demo atomicIntegerDemo1 = new AtomicInteger_Demo("a");
        AtomicInteger_Demo atomicIntegerDemo2 = new AtomicInteger_Demo("b");
        new Thread(atomicIntegerDemo1).start();
        new Thread(atomicIntegerDemo2).start();

    }

    @Override
    public void run() {

        logger.info(name + "开始加.. oldValue=[{}]", count);

        try {
            TimeUnit.SECONDS.sleep(2);
            logger.info(name + "加1 value1=[{}]", count);
            count.incrementAndGet();
            logger.info(name + "加1 value2=[{}]", count);
        } catch (InterruptedException e) {
            // do nothing
        }

        logger.info(name + "结束.. value=[{}]", count);
    }


}
