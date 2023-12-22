package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2866. 美丽塔 II
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 *
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 *      1 <= heights[i] <= maxHeights[i]
 *      heights 是一个 山脉 数组。
 *
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 *      对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 *      对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 *
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 *
 * @author Zeti
 * @date 2023/12/21 10:08
 */
public class MaximumSumOfHeights {

    public static void main(String[] args) {
        List<Integer> m1 = Arrays.asList(5,3,4,1,1);
        System.err.println(maximumSumOfHeights(m1));    // res=13; 和最大的美丽塔方案为 heights = [5,3,3,1,1]

        List<Integer> m2 = Arrays.asList(6,5,3,9,2,7);
        System.err.println(maximumSumOfHeights(m2));    // res=22; 和最大的美丽塔方案为 heights = [3,3,3,9,2,2]

        List<Integer> m3 = Arrays.asList(3,2,5,5,2,3);
        System.err.println(maximumSumOfHeights(m3));    // res=18; 和最大的美丽塔方案为 heights = [2,2,5,5,2,2]

        List<Integer> m4 = Arrays.asList(1000000000,1000000000,1000000000);
        System.err.println(maximumSumOfHeights(m4));    // res=3000000000; 和最大的美丽塔方案为 heights = [1000000000,1000000000,1000000000]


    }

    /**
     * 利用单调栈，存储每个元素作为塔中心时，左右两侧的总和
     *
     * @param maxHeights
     * @return
     */
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int len = maxHeights.size();

        // 单调栈，左右两侧计算总和时，作为一个临时存储下标的介质
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 每个元素作为塔中心时，左侧的总和
        long[] left = new long[len];
        for (int i = 0; i < len; i++) {
            Integer num = maxHeights.get(i);

            // 左侧大于当前元素的值全都出栈，因为需要重新计算
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > num) {
                deque.pop();
            }

            // 栈内剩余的下标对应的左侧和 + 需要重新计算的和 = 当前元素左侧总和
            long sum = deque.isEmpty() ? (long) num * (i + 1) : left[deque.peek()] + (long) num * (i - deque.peek());
            left[i] = sum;

            // 将当前元素下标压入栈，下次循环时使用
            deque.push(i);
        }

        // 清空栈，计算右侧元素和
        deque.clear();

        // 同理，每个元素作为塔中心时，右侧的总和
        long[] right = new long[len];
        for (int i = len-1; i >= 0; i--) {
            Integer num = maxHeights.get(i);

            // 左侧大于当前元素的值全都出栈，因为需要重新计算
            while (!deque.isEmpty() && maxHeights.get(deque.peek()) > num) {
                deque.pop();
            }

            // 栈内剩余的下标对应的左侧和 + 需要重新计算的和 = 当前元素左侧总和
            long sum = deque.isEmpty() ? (long) num * (len - i) : right[deque.peek()] + (long) num * (deque.peek()-i);
            right[i] = sum;

            // 将当前元素下标压入栈，下次循环时使用
            deque.push(i);
        }

        // 计算结果最大和
        long max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, left[i] + right[i] - maxHeights.get(i));
        }
        return max;
    }


    /**
     * 笨方法，遍历所有，超时
     *
     * @param maxHeights
     * @return
     */
    public static long maximumSumOfHeights2(List<Integer> maxHeights) {
        int size = maxHeights.size();
        long max = 0;

        // 尝试让下标为i的元素作为塔的中心，遍历找出和最大的美丽塔
        for (int i = 0; i < size; i++) {
            // 当前塔的总和
            long sum = maxHeights.get(i);

            int l = i-1;
            long ln = maxHeights.get(i);

            // 塔的左边
            while (l >= 0) {
                long min = Math.min(maxHeights.get(l), ln);
                sum += min;
                ln = min;
                l--;
            }

            int r = i+1;
            long rn = maxHeights.get(i);
            // 塔的右边
            while (r < size) {
                long min = Math.min(maxHeights.get(r), rn);
                sum += min;
                rn = min;
                r++;
            }

            max = Math.max(max, sum);
        }
        return max;
    }



}
