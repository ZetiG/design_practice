package com.example.demo.spi;

import java.util.ServiceLoader;

/**
 * Description: SPI 运行测试
 * 1.在 resources/ 下创建文件夹 "META-INF/services" ；
 * 2.以要实现的接口全限定名来命名一个文本文件，并放在 "META-INF/services/" 下；
 * 3.文本文件内逐行写入相应实现；
 * 4.使用ServiceLoader.load()加载该接口的SPI实现；
 *
 * @author Zeti
 * @date 2022/11/17 14:27
 */
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<SpiTest> load = ServiceLoader.load(SpiTest.class, Thread.currentThread().getContextClassLoader());
        for (SpiTest spiTest : load) {
            spiTest.say();
        }
    }


}
