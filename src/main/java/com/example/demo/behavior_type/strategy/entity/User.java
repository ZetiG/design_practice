package com.example.demo.behavior_type.strategy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 包名       com.mamaqunaer.membergrowth.cms.entity
 * 文件名:    MemberUser
 * 创建时间:  2020-05-18
 * 描述:      会员-用户表实体类
 *
 * @author Zeti
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户积分
     */
    private Integer integral;

    /**
     * 用户积分成长值
     */
    private Integer growthIntegral;

    /**
     * 用户等级
     */
    private Integer level;


}
