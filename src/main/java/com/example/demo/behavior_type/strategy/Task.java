package com.example.demo.behavior_type.strategy;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 任务属性 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 11:23 上午
 */
@Data
public class Task implements Serializable {
    private static final long serialVersionUID = 4493849916447097473L;

    /**
     * 任务类型：1关注公众号，2每日签到，3点赞文章，4评论文章，5分享文章，6发布文章
     */
    private TaskTypeEnum taskType;

    /**
     * 是否勾选，0未选 1已选
     */
    private Integer isSelect;

    /**
     * 新增积分值
     */
    private Integer addIntegral;

    /**
     * 上限次数
     */
    private Integer upperLimit;


}
