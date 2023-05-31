package com.example.demo.leetcode.ii;

import java.util.*;

/**
 * Description: 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author Zeti
 * @date 2023/5/31 10:22
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] n1 = {1,1,1,2,2,3};
        int k1 = 2;
        System.err.println(Arrays.toString(topKFrequent(n1, k1)));  // [1,2]

        int[] n2 = {1};
        int k2 = 1;
        System.err.println(Arrays.toString(topKFrequent(n2, k2))); // [1]

    }


    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer itg = map.getOrDefault(num, 0);
            map.put(num, itg+1);
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).map(Map.Entry::getKey).distinct().mapToInt(Integer::intValue).toArray();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
