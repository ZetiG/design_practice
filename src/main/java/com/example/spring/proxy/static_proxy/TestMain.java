package com.example.spring.proxy.static_proxy;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 15:19
 */
public class TestMain {

    @Test
    public void testStaticProxy() {
        //目标对象
        UserDao userDao = new UserDaoImpl();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.getUser(11L);
    }
}
