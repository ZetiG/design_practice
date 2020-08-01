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
public class AtomicIntegerTest implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AtomicIntegerTest.class);

    private String name;

    private AtomicInteger count = new AtomicInteger(0);

    public AtomicIntegerTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest1 = new AtomicIntegerTest("a");
        AtomicIntegerTest atomicIntegerTest2 = new AtomicIntegerTest("b");
        new Thread(atomicIntegerTest1).start();
        new Thread(atomicIntegerTest2).start();

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
