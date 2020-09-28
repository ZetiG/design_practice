package com.example.demo.java_api;

import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.NotThreadSafe;

/**
 * Description: 对象溢出
 *
 * @author Zeti
 * @date 2020/9/28 1:45 下午
 */
@Slf4j
@NotThreadSafe
public class Escape {


    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        System.err.println(new Escape());
    }

}
