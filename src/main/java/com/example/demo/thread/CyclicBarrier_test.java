package com.example.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:  CyclicBarrier: 栅栏，所有的线程必须同时达到栅栏位置才能继续执行
 *
 * <p>
 *     适用于多线程相互等待，直到达到一个屏障点 并且CyclicBarrier是可重用的
 * </p>
 *
 * @author Zeti
 * @date 2021/6/25 上午11:12
 */
public class CyclicBarrier_test {

    // 定义栅栏
    CyclicBarrier cyclicBarrier = new CyclicBarrier(200);


    // 线程池执行
    private void runThread() {
        ExecutorService threadPool = Executors.newFixedThreadPool(400);
        for (int i = 0; i < 400; i++) {
            threadPool.submit(buildThread(i));
        }
    }


    private Thread buildThread(int i) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " ready...");

                // 当线程运行到此，被加入栅栏，等待满足栅栏条件后继续往下走
                cyclicBarrier.await();

                System.out.println("Thread " + Thread.currentThread().getName() + " run...");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.setName("name:" + i);
        return thread;
    }


    public static void main(String[] args) {
        CyclicBarrier_test cbt = new CyclicBarrier_test();
        cbt.runThread();
    }


}
