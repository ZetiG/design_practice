package com.example.demo.leetcode.i;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: 2363. 合并相似的物品
 * 
 * 给你两个二维整数数组items1 和items2，表示两个物品集合。每个数组items有以下特质：
 *      items[i] = [valuei, weighti] 其中valuei表示第i件物品的价值，weighti表示第 i件物品的 重量。
 *      items中每件物品的价值都是 唯一的。
 *
 * 请你返回一个二维数组ret，其中ret[i] = [valuei, weighti]，weighti是所有价值为valuei物品的重量之和。
 * 注意：ret应该按价值 升序排序后返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-similar-items
 *
 * @author Zeti
 * @date 2023/2/28 19:45
 */
public class MergeSimilarItems {

    public static void main(String[] args) {

        // 输入：items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
        // 输出：[[1,6],[3,9],[4,5]]
        int[][] items1 = {{4,5}, {1,1}, {3,8}};
        int[][] items2 = {{3,1}, {1,5}};
        System.err.println(mergeSimilarItems(items1, items2));

    }


    /**
     * 用treemap可自动排序
     */
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        return Stream.concat(Arrays.stream(items1), Arrays.stream(items2))
                .collect(Collectors.toMap(item -> item[0], item -> item[1], Integer::sum, TreeMap::new))
                .entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


    public static List<List<Integer>> mergeSimilarItems2(int[][] items1, int[][] items2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            Integer integer = map.get(items1[i][0]);
            if (integer == null) {
                map.put(items1[i][0], items1[i][1]);
                continue;
            }
            integer = integer + items1[i][1];
            map.put(items1[i][0], integer);
        }

        for (int i = 0; i < items2.length; i++) {
            Integer integer = map.get(items2[i][0]);
            if (integer == null) {
                map.put(items2[i][0], items2[i][1]);
                continue;
            }
            integer = integer + items2[i][1];
            map.put(items2[i][0], integer);
        }

        return map.entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


}
