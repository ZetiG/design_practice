package com.example.demo._23_design_patterns.发布订阅模式;

/**
 * Description: 事件类
 *
 * @author Zeti
 * @date 2023/12/4 15:08
 */
public class NewsEvent {
    private String news;

    public NewsEvent(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}
