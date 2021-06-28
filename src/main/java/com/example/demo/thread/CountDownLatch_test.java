package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: CountDownLatch 计数器，让所有线程等待直到计数器值为0
 *
 * @author Zeti
 * @date 2021/6/25 下午2:50
 */
public class CountDownLatch_test {

    CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        CountDownLatch_test cdl = new CountDownLatch_test();
        cdl.countDownLatchTest();
    }

    private void countDownLatchTest() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 开启5个线程
        for (int i = 0; i < 5; i++) {
            threadPool.submit(createThread());
        }

        // 5个线程提交后，执行准备，然后countDownLatch.await()进入等待，当前计数器初始值为1，
        // 这时执行countDownLatch.countDown()计数器清零，5个线程开始继续执行
        countDownLatch.countDown();
    }


    private Thread createThread() {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread: "+Thread.currentThread().getName()+", 准备...");

                countDownLatch.await();
                System.out.println("Thread: "+Thread.currentThread().getName()+", 开始...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //do something
        });
        return thread;
    }


}
