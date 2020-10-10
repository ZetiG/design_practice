package com.example.demo.spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/10/9 11:18 上午
 */
public class PersonAction implements Action, InitializingBean {

    private String name;

    @Override
    public void say() {
        System.err.println(name + "- say hahaha");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean 的 after 方法...");
    }

    public void init(){
        System.out.println("调用init方法");
    }

}
