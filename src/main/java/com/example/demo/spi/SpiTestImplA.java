package com.example.demo.spi;

/**
 * Description:
 *
 * @author Zeti
 * @date 2022/11/17 14:26
 */
public class SpiTestImplA implements SpiTest{
    @Override
    public void say() {
        System.err.println("hello A!");
    }
}
