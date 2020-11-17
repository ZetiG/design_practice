package com.example.demo.blocking_queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: synchronized 和 lock 阻塞队列性能对比
 *
 * @author Zeti
 * @date 2020/11/17 下午3:33
 */
public class Test_Queue {

    @Test
    public void testWithMonitor() {
        IQueue<Integer> queue = new ArrayBlockingQueueWithSync<>(5);
        execute(queue);
    }

    @Test
    public void testWithCondition() {
        IQueue<Integer> queue = new ArrayBlockingQueueWithLock<>(5, false);
        execute(queue);
    }

    private void execute(IQueue<Integer> queue) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 1000; i++) {
            final int finalNum = i;
            executorService.execute(() -> {
                try {
                    queue.add(finalNum);
                    Integer take = queue.take();
                    System.out.println("element: " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }


}
