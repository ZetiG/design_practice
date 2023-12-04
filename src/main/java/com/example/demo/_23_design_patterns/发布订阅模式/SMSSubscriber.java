package com.example.demo._23_design_patterns.发布订阅模式;

/**
 * Description: 体的订阅者2
 *
 * @author Zeti
 * @date 2023/12/4 15:11
 */
public class SMSSubscriber implements NewsSubscriber {

    @Override
    public void receiveNews(NewsEvent event) {
        System.out.println("SMSSubscriber received news: " + event.getNews());
    }

}
