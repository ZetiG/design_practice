package com.example.demo.behavior_type.strategy.db;

import com.example.demo.behavior_type.strategy.entity.User;

/**
 * Description: 模拟用户信息数据库操作 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 2:06 下午
 */
public class UserDao {

    public User selectById(Long userId) {
        System.out.println("查询用户数据库，当前用户id：" + userId);
        User user = new User();
        user.setId(userId);
        user.setIntegral(0);
        return user;
    }

    public boolean update(User user) {
        return true;
    }

}
