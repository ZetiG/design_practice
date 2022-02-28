package com.example.demo.coding;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description: 订单超时取消主逻辑 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/2/28 3:51 PM
 */
@Component
public class OrderTimeOutCancel implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancel.class);

    @Resource
    private RedissonClient redissonClient;


    @Override
    public void run(String... args) throws Exception {
        RBlockingQueue<String> blockingRedPacketQueue = redissonClient.getBlockingQueue("userOrderKey");

        RDelayedQueue<String> delayedRedPacketQueue = redissonClient.getDelayedQueue(blockingRedPacketQueue);

        while (true) {
            /**
             * 如果当前没有失效的订单，则此循环会暂时阻塞
             * 取出超时订单信息
             */
            String redPacket = blockingRedPacketQueue.take();
            LOGGER.info("订单号:{}过期失效", redPacket);
            /**
             * 处理相关业务逻辑
             */
        }
    }

}
