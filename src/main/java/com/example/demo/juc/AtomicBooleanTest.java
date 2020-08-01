package com.example.demo.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.comparator.Comparators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/7/29 9:37 上午
 */
public class AtomicBooleanTest implements Runnable {
    private static AtomicBoolean exit = new AtomicBoolean(false);
    private Logger logger = LoggerFactory.getLogger(AtomicBooleanTest.class);
    private String name;

    private AtomicBooleanTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AtomicBooleanTest booleanTest1 = new AtomicBooleanTest("ones");
        AtomicBooleanTest booleanTest2 = new AtomicBooleanTest("twos");
        new Thread(booleanTest1).start();
        new Thread(booleanTest2).start();

    }

    @Override
    public void run() {

        if (exit.compareAndSet(false, true)) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                // do nothing
            }

            logger.info(name + "enter");

            try {
                logger.info(name + " working");

                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }

            logger.info(name + " leave");
            exit.set(false);

        } else {
            System.out.println(name + " give up");
        }
    }

}
