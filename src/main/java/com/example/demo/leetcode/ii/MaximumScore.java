package com.example.demo.leetcode.ii;

import java.util.Stack;

/**
 * Description: 1793. 好子数组的最大分数
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 * 请你返回 好 子数组的最大可能 分数 。
 *
 *
 * @author Zeti
 * @date 2024/3/19 10:42
 */
public class MaximumScore {

    public static void main(String[] args) {
        int[] n1 = {1,4,3,7,4,5};
        int k1 = 3;
        System.err.println(maximumScore(n1, k1));   // 15

        int[] n2 = {5,5,4,5,4,1,1,1};
        int k2 = 0;
        System.err.println(maximumScore(n2, k2));   // 20

    }

    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k; // 左指针从k开始
        int right = k; // 右指针从k开始
        int minNum = nums[k]; // 记录当前窗口内的最小值
        int maxScore = minNum; // 初始分数为最小值

        // 双指针扩展窗口，直到两个指针都超出数组边界
        while (left > 0 || right < n - 1) {
            // 如果右指针可以向右移动，并且右边的数大于等于左边的数，扩展右指针
            if (right < n - 1 && (left == 0 || nums[right + 1] >= nums[left - 1])) {
                minNum = Math.min(minNum, nums[++right]);
            } else { // 否则，扩展左指针
                minNum = Math.min(minNum, nums[--left]);
            }
            maxScore = Math.max(maxScore, minNum * (right - left + 1)); // 更新最大分数
        }
        return maxScore;
    }



    public static int maximumScore2(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n]; // 存储左侧第一个小于nums[i]的元素下标
        int[] right = new int[n]; // 存储右侧第一个小于nums[i]的元素下标

        // 单调递增栈，存储元素下标
        Stack<Integer> stack = new Stack<>();

        // 计算left数组
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 清空栈
        stack.clear();

        // 计算right数组
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxScore = 0;

        // 遍历数组，计算每个可能的子数组的分数，取最大值
        for (int i = 0; i < n; i++) {
            if (left[i] < k && right[i] > k) {
                maxScore = Math.max(maxScore, nums[i] * (right[i] - left[i] - 1));
            }
        }

        return maxScore;
    }




}
