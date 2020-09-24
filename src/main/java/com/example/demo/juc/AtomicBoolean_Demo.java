package com.example.demo.juc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/7/29 9:37 上午
 */
public class AtomicBoolean_Demo implements Runnable {
    private static AtomicBoolean exit = new AtomicBoolean(false);
    private Logger logger = LoggerFactory.getLogger(AtomicBoolean_Demo.class);
    private String name;

    private AtomicBoolean_Demo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AtomicBoolean_Demo booleanTest1 = new AtomicBoolean_Demo("ones");
        AtomicBoolean_Demo booleanTest2 = new AtomicBoolean_Demo("twos");
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
