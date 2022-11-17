package com.example.demo.limit_flow;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/**
 * Description: 漏桶
 *
 * @author Zeti
 * @date 2022/10/7 09:52
 */
public class leaky_bucket {

    private int capacity;   // 容量
    private int rate;   // 每秒固定出水率
    private int current_water = 0;  // 当前桶内水量
    private long last_time = System.currentTimeMillis();    // 上次漏水时间ms

    public leaky_bucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
    }

    public boolean leaky(int water) {
        long current_millis = System.currentTimeMillis();

        // 截止到上次漏水时间，漏出的水量
        long leaky_water = (current_millis - last_time) / 1000 * rate;

        long new_current_water = current_water - leaky_water;

        last_time = current_millis;

        if (new_current_water + 1 < capacity) {
            current_water += water;
            System.err.println(currentThread() + "桶未满，当前已用容量：" + current_water);
            return true;
        } else {
            System.err.println(currentThread() + "桶已满");
            throw new IllegalStateException("桶满了！！");
        }

    }


    public static void main(String[] args) {
        final leaky_bucket bucket = new leaky_bucket(10,1);
        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);    // 生产线程 10个线程 每秒提交 50个数据  1/0.2s*10=50个
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                for (; ; ) {
                    int data = DATA_CREATOR.incrementAndGet();
                    try {
                        bucket.leaky(data);
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (Exception e) {
                        //对submit时，如果桶满了可能会抛出异常
                        if (e instanceof IllegalStateException) {
                            System.out.println(e.getMessage());
                            //当满了后，生产线程就休眠1分钟
                            try {
                                TimeUnit.SECONDS.sleep(60);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        });

        //消费线程  采用RateLimiter每秒处理10个  综合的比率是5:1
//        IntStream.range(0, 10).forEach(i -> {
//            new Thread(
//                    () -> {
//                        for (; ; ) {
//                            bucket.takeThenConsumer(x -> System.out.println(currentThread()+"C.." + x));
//                        }
//                    }
//            ).start();
//        });

    }

}
