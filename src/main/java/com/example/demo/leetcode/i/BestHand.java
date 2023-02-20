package com.example.demo.leetcode.i;

import java.util.*;

/**
 * Description: 2347. 最好的扑克手牌
 *  给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 *  下述是从好到坏你可能持有的 手牌类型 ：
 *             "Flush"：同花，五张相同花色的扑克牌。
 *             "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 *             "Pair"：对子，两张大小一样的扑克牌。
 *             "High Card"：高牌，五张大小互不相同的扑克牌。
 *  请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 *  注意：返回的字符串 大小写 需与题目描述相同。
 * @author Zeti
 * @date 2023/2/20 19:22
 */
public class BestHand {

    public static void main(String[] args) {

        // Flush
        int[] ranks = {13,2,3,1,9};
        char[] suits = {'a','a','a','a','a'};
        System.err.println(bestHand(ranks, suits));

        // Three of a Kind
        int[] ranks2 = {4,4,2,4,4};
        char[] suits2 = {'d','a','a','b','c'};
        System.err.println(bestHand(ranks2, suits2));

        // Pair
        int[] ranks3 = {10,10,2,12,9};
        char[] suits3 = {'a','b','c','a','d'};
        System.err.println(bestHand(ranks3, suits3));


    }


    public static String bestHand(int[] ranks, char[] suits) {
        if (ranks.length == 0 || suits.length == 0) {
            return null;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for (char suit : suits) {
            map1.put(suit, 1);
        }
        // "Flush"：同花，五张相同花色的扑克牌。
        if (map1.size() == 1) {
            return "Flush";
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int rank : ranks) {
            Integer ct = map2.get(rank);
            if (ct == null) {
                ct = 0;
            }
            map2.put(rank, ct + 1);
        }

        // "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
        List<Integer> values = new ArrayList<>(map2.values());
        int size = values.size();
        Integer max = values.stream().max(Comparator.naturalOrder()).get();

        // "High Card"：高牌，五张大小互不相同的扑克牌。
        if (size == 5) {
            return "High Card";
        }

        //  "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
        if (max >= 3) {
            return "Three of a Kind";

        } else if (max == 2) {  // "Pair"：对子，两张大小一样的扑克牌。
            return "Pair";
        }
        return null;
    }



}
