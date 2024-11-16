package com.example.spring.proxy.static_proxy;

/**
 * Description: 静态代理
 *
 * 这种代理方式需要代理对象和目标对象实现一样的接口。
 *
 * 优点：可以在不修改目标对象的前提下扩展目标对象的功能。
 *
 * 缺点：
 *      冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
 *      不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
 *
 * @author Zeti
 * @date 2024/11/16 15:18
 */
public class UserDaoProxy implements UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser(Long id) {
        System.err.println("代理start");
        userDao.getUser(id);
        System.err.println("代理end");
    }
}
