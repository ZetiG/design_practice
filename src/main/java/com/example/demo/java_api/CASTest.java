package com.example.demo.java_api;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/2/10 17:32
 */
public class CASTest implements Runnable {
    static int i = 0;

    public synchronized static void increment() {
        i++;
    }


    public static void main(String[] args) throws InterruptedException {
        CASTest t = new CASTest();
        for (int j = 0; j < 10; j++) {
            new Thread(t).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.err.println(i);

    }

    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            increment();
        }
        System.err.println("end当前：" + Thread.currentThread().getName() + "--》" + i);

    }
}
