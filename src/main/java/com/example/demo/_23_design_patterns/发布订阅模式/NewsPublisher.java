package com.example.demo._23_design_patterns.发布订阅模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 发布者
 *
 * @author Zeti
 * @date 2023/12/4 15:08
 */
public class NewsPublisher {

    private List<NewsSubscriber> subscribers = new ArrayList<>();

    public void subscribe(NewsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(NewsSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String news) {
        NewsEvent event = new NewsEvent(news);
        for (NewsSubscriber subscriber : subscribers) {
            subscriber.receiveNews(event);
        }
    }
}
