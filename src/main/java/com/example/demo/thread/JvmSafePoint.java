package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: JVM GC 安全点
 *
 *    HotSpot虚拟机为了避免安全点过多带来过重的负担，对循环还有一项优化措施，认为循环次数较少的话，执行时间应该也不会太长，所以使用int
 * 类型或范围更小的数据类型作为索引值的循环默认是不会被放置安全点的。这种循环被称为可数循环（Counted Loop），
 * 相对应地，使用long或者范围更大的数据类型作为索引值的循环就被称为不可数循环（Uncounted Loop），将会被放置安全点。
 *
 * @author Zeti
 * @date 2022/10/8 14:14
 */
public class JvmSafePoint {

    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 100000000; i++) {
                num.getAndSet(i);
            }
            System.out.println("-执行结束！");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + "-num = " + num);
    }


}
