package com.example.demo.coding;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/2/28 3:48 PM
 */
@Configuration
public class RedisQueueConfig {


    // 连接redis的地址
    @Value("${spring.redis.host}")
    private String host;

    //redis的端口号
    @Value("${spring.redis.port}")
    private String port;

    //redis的密码
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient(){
        //此处为单机配置，高可用配置请往下看
        Config config = new Config();
        if (password.equals("")){
            config.setCodec(new org.redisson.client.codec.StringCodec());
            config.useSingleServer().setAddress("redis://" + host + ":" + port).setDatabase(0).setTimeout(5000);
        }else {
            config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password).setDatabase(0).setTimeout(5000);
        }

        return Redisson.create(config);
    }

    /**
     * 主从部署方式
     */
//    Config config = new Config();
//    config.useMasterSlaveServers()
//        //设置redis主节点
//        .setMasterAddress("redis://127.0.0.1:6379")
//        //设置redis从节点
//        .addSlaveAddress("redis://127.0.0.2:6379", "redis://127.0.0.3:6379");
//    RedissonClient redisson = Redisson.create(config);


    /**
     * 集群部署方式
     * cluster方式至少6个节点
     * 3主3从，3主做sharding，3从用来保证主宕机后可以高可用
     */
//    Config config = new Config();
//    config.useClusterServers()
//        .setScanInterval(2000)//集群状态扫描间隔时间，单位是毫秒
//        .addNodeAddress("redis://127.0.0.1:6379")
//        .addNodeAddress("redis://127.0.0.2:6379")
//        .addNodeAddress("redis://127.0.0.3:6379")
//        .addNodeAddress("redis://127.0.0.4:6379")
//        .addNodeAddress("redis://127.0.0.5:6379")
//        .addNodeAddress("redis://127.0.0.6:6379");
//    RedissonClient redissonClient = Redisson.create(config);

    /**
     * 哨兵部署方式
     * sentinel是采用 Paxos拜占庭协议，一般sentinel至少3个节点
     */
//    Config config = new Config();
//    config.useSentinelServers()
//        .setMasterName("my-sentinel-name")
//        .addSentinelAddress("redis://127.0.0.1:6379")
//        .addSentinelAddress("redis://127.0.0.2:6379")
//        .addSentinelAddress("redis://127.0.0.3:6379");
//    RedissonClient redisson = Redisson.create(config);


}
