package com.example.demo;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/12/6 14:21
 */
public class Test_01 {

    @Test
    public void t1() {
        long id = 123456789L;
        String shortUrl = encodeBase62(id);
        System.out.println("Short URL: " + shortUrl);
    }

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // 生成百亿无重复短url，根据数据库自增id或分布式唯一id生成器生成唯一id，将该唯一id使用base62编码得到短url
    // 将自增 ID 转换为 Base62
    public static String encodeBase62(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62.charAt((int) (id % 62)));
            id /= 62;
        }
        return sb.reverse().toString();
    }

}
