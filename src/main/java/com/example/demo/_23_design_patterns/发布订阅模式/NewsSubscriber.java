package com.example.demo._23_design_patterns.发布订阅模式;

/**
 * Description: 订阅者接口
 *
 * @author Zeti
 * @date 2023/12/4 15:09
 */
public interface NewsSubscriber {

    void receiveNews(NewsEvent event);

}
