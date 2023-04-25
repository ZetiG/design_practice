package com.example.demo.leetcode.ii;

import java.util.HashSet;

/**
 * Description: 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author Zeti
 * @date 2023/4/25 11:15
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] n1 = {100,4,200,1,3,2};
        System.err.println(longestConsecutive(n1));

    }

    // 输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    //示例 2：
    //
    //输入：nums = [0,3,7,2,5,8,4,6,0,1]
    //输出：9
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            // 如果当前num-1 不在集合内，则代表num是"一组数字"的最小值；否则num不是最小值
            if (!set.contains(num-1)) {
                int currentNum = num;
                int maxCt = 1;

                while (set.contains(currentNum+1)) {
                    currentNum++;
                    maxCt++;
                }
                res = Math.max(res, maxCt);
            }
        }
        return res;
    }


}
