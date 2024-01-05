package com.example.demo.leetcode.iii;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Description: 1944. 队列中可以看到的人数
 *
 * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
 *
 * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max
 * (heights[i+1], heights[i+2], ..., heights[j-1]) 。
 *
 * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
 *
 * @author Zeti
 * @date 2024/1/5 09:22
 */
public class CanSeePersonsCount {

    public static void main(String[] args) {
        int[] h1 = {10,6,8,5,11,9};
        System.err.println(Arrays.toString(canSeePersonsCount(h1)));   // [3,1,2,1,1,0]

        int[] h2 = {5,1,2,3,10};
        System.err.println(Arrays.toString(canSeePersonsCount(h2)));   // [4,1,1,1,0]

    }

    // 10,6,8,5,11,9
    public static int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] ans = new int[length];    // 结果集

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 倒序遍历，逐个入栈，并弹出栈内小于当前值的元素且计数(计算右侧矮于当前值的元素数量)
        for (int i = length-1; i >= 0; i--) {
            // 当栈不为空，且栈顶元素小于当前值，则代表当前值可以看到栈顶的元素，这时当前元素可以看到的值+1；
            while (!deque.isEmpty() && deque.peek() < heights[i]) {
                deque.pop();
                ans[i]++;
            }

            // 小于当前元素的数量计算后，如果栈内还有值，则证明存在大于当前元素的值，需要加1,（这是第一个大于当前元素的值，也是看的最远的位置）
            if (!deque.isEmpty()) {
                ans[i]++;
            }

            deque.push(heights[i]);
        }
        return ans;
    }

    // 超时, 笨方法-逐个遍历数组中右侧所有元素并判断是否符合条件
    public static int[] canSeePersonsCount2(int[] heights) {
        int length = heights.length;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int curr = heights[i];

            for (int j = i+1; j < length; j++) {
                int height = heights[j];
                if (deque.isEmpty()) {
                    deque.push(height);
                } else {
                    Integer peek = deque.peek();
                    if (peek <= height) {
                        deque.push(height);
                    }
                }

                if (deque.peek() >= curr) {
                    break;
                }
            }

            heights[i] = deque.size();
            deque.clear();
        }
        return heights;
    }

}
