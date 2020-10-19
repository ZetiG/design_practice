package com.example.demo.spring.IScope;

import org.springframework.context.annotation.Scope;

/**
 * Description: 测试对象 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/10/17 2:13 下午
 */
@Scope(scopeName = "iScope")
public class TestClass {

    public TestClass() {
        System.out.println("test class construct 。。。");
    }

}
