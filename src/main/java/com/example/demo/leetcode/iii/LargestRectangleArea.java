package com.example.demo.leetcode.iii;

import java.util.*;

/**
 * Description: 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author Zeti
 * @date 2023/6/13 10:54
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] h1 = {2,1,5,6,2,3};
        System.err.println(largestRectangleArea(h1));   // 10

        int[] h2 = {2,4};
        System.err.println(largestRectangleArea(h2));   // 4

        int[] h3 = {1,2,2};
        System.err.println(largestRectangleArea(h3));   // 4

        int[] h4 = {1,2,3,4,5};
        System.err.println(largestRectangleArea(h4));   // 9

    }

    //              |
    //          |   |
    //      |   |   |
    //   |  |   |   |
    // | |  |   |   |
    // 方法1
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] arr = new int[heights.length+2];
        System.arraycopy(heights, 0, arr, 1, heights.length);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i ++) {

            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                int curr = deque.pop(); // 当前待计算的下标
                int l = deque.peek();
                int r = i;
                res = Math.max(res, (r-l-1) * arr[curr]);
            }
            deque.push(i);
        }
        return res;
    }

    // 方法2
    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }



}
