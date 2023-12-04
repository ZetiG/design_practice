package com.example.demo._23_design_patterns.发布订阅模式;

/**
 * Description: 具体的订阅者1
 *
 * @author Zeti
 * @date 2023/12/4 15:11
 */
public class EmailSubscriber implements NewsSubscriber {

    @Override
    public void receiveNews(NewsEvent event) {
        System.out.println("EmailSubscriber received news: " + event.getNews());
    }

}
