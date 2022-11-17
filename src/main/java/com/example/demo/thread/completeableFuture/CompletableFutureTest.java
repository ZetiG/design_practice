package com.example.demo.thread.completeableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Description:
 *
 * @author Zeti
 * @date 2022/11/17 15:30
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> supplyAsync = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        // exec success
        supplyAsync.thenAccept(res -> System.out.println("price: " + res));

        // throw exception
        supplyAsync.exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }


    static Double fetchPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

}
