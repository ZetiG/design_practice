package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.db;

/**
 * Description: 任务完成情况 模拟数据库操作 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 2:08 下午
 */
public class UserCompleteTaskLogDao {


    /**
     * 查询当前任务完成次数
     *
     * @param type
     * @return
     */
    public Integer selectCompleteLogByType(Integer type) {
        System.out.println("查询任务完成情况数据库，当前任务：" + type);
        return 3;
    }


}
