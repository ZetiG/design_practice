package com.example.demo.coding.order_canal_redisson;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Description: 测试伪下单类 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/2/28 3:49 PM
 */
@RestController
public class Test_OrderController {

    @Resource
    private RedissonClient redissonClient;


    @GetMapping("/order")
    public String hello() {

        /**
         * 目标队列
         */
        RBlockingQueue<String> blockingRedPacketQueue = redissonClient.getBlockingQueue("userOrderKey");
        /**
         * 定时任务将到期的元素转移到目标队列
         */
        RDelayedQueue<String> delayedRedPacketQueue = redissonClient.getDelayedQueue(blockingRedPacketQueue);
        /**
         * 123456代表订单号，放入队列中
         * 设置10秒后到期
         */
        delayedRedPacketQueue.offer("123456", 10, TimeUnit.SECONDS);
        return "OK";
    }

}
