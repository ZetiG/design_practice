package com.example.demo.leetcode.ii;


import java.util.*;

/**
 * Description: 2034. 股票价格波动
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 *
 * 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
 *
 * 请你设计一个算法，实现：
 *
 * 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
 * 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
 * 找到当前记录里股票的 最高价格 。
 * 找到当前记录里股票的 最低价格 。
 *
 * 请你实现 StockPrice 类：
 *
 * StockPrice() 初始化对象，当前无股票价格记录。
 * void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
 * int current() 返回股票 最新价格 。
 * int maximum() 返回股票 最高价格 。
 * int minimum() 返回股票 最低价格 。
 *
 * @author Zeti
 * @date 2023/10/8 17:28
 */
public class StockPrice {

    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.update(1,10);
        sp.update(2,5);
        System.err.println(sp.current());
        System.err.println(sp.maximum());
        sp.update(1, 3);
        System.err.println(sp.maximum());
        sp.update(4, 2);
        System.err.println(sp.minimum());

    }

    int currTimestamp;
    HashMap<Integer, Integer> kvMap;
    TreeMap<Integer, Integer> tree;

    public StockPrice() {
        currTimestamp = 0;
        kvMap = new HashMap<>();
        tree = new TreeMap<>();
    }

    // ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
    // [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
    // 股票价格记录可能不是按时间顺序到来的。
    // 如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录
    public void update(int timestamp, int price) {
        // 更新当前最新的时间戳
        currTimestamp = Math.max(currTimestamp, timestamp);

        // 判断当前时间戳是否首次流入，若prePrice>0则代表非首次流入，则更新当前时间戳的价格
        Integer prePrice = kvMap.getOrDefault(timestamp, 0);

        // 插入当前timestamp的price，不管是否为首次流入都不影响，上次的价格已经取出prePrice
        kvMap.put(timestamp, price);

        if (prePrice > 0) {
            // prePrice>0时，非首次流入，属于更新操作
            int num = tree.getOrDefault(prePrice, 0) - 1;
            if (num <= 0) {
                tree.remove(prePrice);
            } else {
                tree.put(prePrice, num);
            }
        }

        // 更新排序, key：当前价格；value：当前价格出现的次数
        tree.put(price, tree.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return kvMap.get(currTimestamp);
    }

    public int maximum() {
        return tree.lastKey();
    }

    public int minimum() {
        return tree.firstKey();
    }


}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */