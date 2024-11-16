package com.example.spring.proxy.cglib_proxy;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 15:14
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser(Long id) {
        System.err.printf("用户-userId:[%d]%n", id);
    }
}
