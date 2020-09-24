package com.example.demo.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description: 循环栅栏
 * <p>
 * CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。
 * 主要应用场景和 CountDownLatch 类似。
 * <p>
 * CountDownLatch的实现是基于AQS的，而CycliBarrier是基于 ReentrantLock(ReentrantLock也属于AQS同步器)和 Condition 的.
 *
 * @author Zeti
 * @date 2020/9/23 2:29 下午
 */
public class CyclicBarrier_Demo {

    private static final int threadCount = 550;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int thread = i;

            try {

                Thread.sleep(1000);

                threadPool.execute(() -> test(thread));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }

        threadPool.shutdown();

    }


    public static void test(int threadNum) {

        System.out.println("threadnum:" + threadNum + "is ready");
        try {
            /**等待60秒，保证子线程完全执行结束*/
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadNum + "is finish");
    }



}
