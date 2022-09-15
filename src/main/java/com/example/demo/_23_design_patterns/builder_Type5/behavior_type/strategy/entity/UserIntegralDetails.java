package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 包名       com.mamaqunaer.membergrowth.cms.entity
 * 文件名:    MemberIntegralDetails
 * 创建时间:  2020-05-18
 * 描述:      积分明细表实体类
 *
 * @author Zeti
 */
@Data
public class UserIntegralDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 会员id
     */
    private Long memberUserId;

    /**
     * 积分变动情况
     */
    private String integralChange;

    /**
     * 积分余额
     */
    private Integer integralBalance;

    /**
     * 操作类型: 0收入  1支出
     */
    private Integer operatorType;

    /**
     * 积分类型: 0无(默认)，1平台减少，2禁用文章，3禁用文章评论，4平台增加，5点赞文章，6评论文章，7发布文章(审核通过)，8扫码兑换，9关注公众号，10每日签到，11连续签到
     */
    private Integer integralType;


}
