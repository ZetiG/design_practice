package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 包名       com.mamaqunaer.membergrowth.cms.entity
 * 文件名:    SettingTask
 * 创建时间:  2020-05-18
 * 描述:      任务积分设置表实体类
 *
 * @author Zeti
 */
@Data
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 任务类型：1关注公众号，2每日签到，3点赞文章，4评论文章，5分享文章，6发布文章
     */
    private Integer taskType;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 是否勾选，0未选 1已选
     */
    private Integer isSelect;

    /**
     * 新增积分
     */
    private Integer addIntegral;

    /**
     * 上限次数
     */
    private Integer upperLimit;


}
