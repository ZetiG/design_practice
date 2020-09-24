package com.example.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Description: semaphore 信号量--允许多个线程同时访问
 *
 * @author Zeti
 * @date 2020/9/23 1:55 下午
 */
public class Semaphore_Demo {

    private static final int threadCount = 50;

    public static void main(String[] args) {

        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);

        // 一次只能允许执行的线程数量。 [permits:一次允许执行的线程数量] [fair:公平/非公平机制]
        final Semaphore semaphore = new Semaphore(20, false);

        for (int i = 0; i < threadCount; i++) {
            int threadNum = i;

            threadPool.execute(() -> {

                try {
                    // 获得执行许可
                    semaphore.acquire();

                    // 获取5个许可，所以可运行线程数量为20/5=4
//                    semaphore.acquire(5);

                    // do something
                    test(threadNum);

                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        threadPool.shutdown();

        System.out.println("finish");

    }


    public static void test(int threadNum) throws InterruptedException {

        TimeUnit.SECONDS.sleep(1); // 模拟请求的耗时操作
        System.out.println("threadNum:" + threadNum);
        TimeUnit.SECONDS.sleep(1); // 模拟请求的耗时操作

    }

}
