package com.example.demo.behavior_type.strategy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 包名       com.mamaqunaer.membergrowth.cms.entity
 * 文件名:    MemberCompleteTaskLog
 * 创建时间:  2020-05-27
 * 描述:      会员-任务完成表实体类
 *
 * @author Zeti
 */
@Data
public class UserCompleteTaskLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会员用户id
     */
    private Long userId;

    /**
     * 任务类型：1关注公众号，2每日签到，3点赞文章，4评论文章，5分享文章，6发布文章
     */
    private Integer taskType;

    /**
     * 任务完成时间
     */
    private Long completeTime;


}
