package com.example.demo.blocking_queue;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * Description: synchronized 和 lock 阻塞队列性能对比
 *
 * @author Zeti
 * @date 2020/11/17 下午3:33
 */
public class Test_Queue {

    @Test
    public void testWithMonitor() {
        IBlockingQueue<Integer> queue = new ArrayBlockingQueueWithSync<>(5);
        execute(queue);
    }

    @Test
    public void testWithCondition() {
        IBlockingQueue<Integer> queue = new ArrayBlockingQueueWithLock<>(5, false);
        execute(queue);
    }


    private void execute(IBlockingQueue<Integer> queue) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 1000; i++) {
            final int finalNum = i;
            executorService.execute(() -> {
                try {
                    boolean put = queue.put(finalNum, 50, TimeUnit.SECONDS);
                    System.err.println("put: " + finalNum + " - " + put);

//                    Thread.sleep(3);
//                    Integer take = queue.take();
//                    System.out.println("take e: " + take);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }


// -------------------------------------- JUC ArrayBlockingQueue ------------------------------------------------------

    @Test
    public void testWithJucCondition() {
        ArrayBlockingQueue<Integer> jucQueue = new ArrayBlockingQueue<>(5, false);
        jucExecute(jucQueue);
    }


    private void jucExecute(BlockingQueue<Integer> queue) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 1000; i++) {
            final int finalNum = i;
            executorService.execute(() -> {
                try {
                    boolean offer = queue.offer(finalNum, 5, TimeUnit.SECONDS);
                    System.err.println("juc offer: " + finalNum + " - " + offer);

//                    Integer take = queue.take();
//                    System.out.println("element: " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }



}
