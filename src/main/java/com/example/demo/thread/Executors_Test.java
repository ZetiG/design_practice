package com.example.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description: 多线程和线程池
 *
 * <p>
 * 创建多线程的方式：
 * 1.继承Thread类，重写run方法
 * 2.实现runnable接口, 重写run方法
 * 3.创建FutureTask对象，创建Callable子类对象，复写call(相当于run)方法，将其传递给FutureTask对象（相当于一个Runnable）
 * 4.通过线程池创建
 * </p>
 *
 * <p>
 * 不推荐Executors类创建线程池，因为存在最大值，容易造成内存泄漏
 * </p>
 *
 * @author Zeti
 * @date 2020/9/18 2:05 下午
 */
public class Executors_Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(Executors_Test::run);

//        ExecutorService executorService1 = Executors.newFixedThreadPool(3);


    }

    private static void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": start");
    }


}
