package com.example.demo.leetcode.ii;

import java.util.PriorityQueue;

/**
 * Description: 2530. 执行 K 次操作后的最大分数
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 *
 * @author Zeti
 * @date 2023/10/18 15:18
 */
public class MaxKelements {
    public static void main(String[] args) {
        int[] n1 = {10, 10, 10, 10, 10};
        int k1 = 5;
        System.err.println(maxKelements(n1, k1));   // 50

        int[] n2 = {1, 10, 3, 3, 3};
        int k2 = 3;
        System.err.println(maxKelements(n2, k2));   // 17

    }

    public static long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < k; i++) {
            Integer n = queue.poll();
            res += n;
            queue.offer((n + 2) / 3); // 等价代替，避免浮点数 [(n+2)/3 == (n/3)]
        }

        return res;
    }

}