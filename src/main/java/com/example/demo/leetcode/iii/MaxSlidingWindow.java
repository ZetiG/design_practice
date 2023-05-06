package com.example.demo.leetcode.iii;

import java.util.*;

/**
 * Description: 239. 滑动窗口最大值
 *  给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *  返回 滑动窗口中的最大值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/6 16:04
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] n1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        System.err.println(Arrays.toString(maxSlidingWindow(n1, k1)));   // [3,3,5,5,6,7]

        int[] n2 = {1};
        int k2 = 1;
        System.err.println(Arrays.toString(maxSlidingWindow(n2, k2)));   // [1]

        int[] n3 = {1,-1};
        int k3 = 1;
        System.err.println(Arrays.toString(maxSlidingWindow(n3, k3)));   // [1,-1]

        int[] n4 = {7,2,4};
        int k4 = 2;
        System.err.println(Arrays.toString(maxSlidingWindow(n4, k4)));   // [7,4]

        int[] n5 = {4,3,11};
        int k5 = 3;
        System.err.println(Arrays.toString(maxSlidingWindow(n5, k5)));   // [11]

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 双边队列，实现单调递减队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            // 如果队列不为空，且当前数组元素>=队尾元素，则进行替换; 时刻保持当前队列内为单调递减
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();   // 移除队尾元素
            }
            // 添加元素到队尾
            deque.offerLast(i);
        }

        // 结果集
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            int current = nums[i];  // 当前遍历的元素

            // 同上；如果队列不为空，且当前数组元素>=队尾元素，则进行替换
            while (!deque.isEmpty() && nums[deque.peekLast()] <= current) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 如果队首元素下标小于i-k，代表当前队首元素不在当前窗口内，则移除队首元素
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            // 队首一定是最大的元素下标
            res[i-k+1] = nums[deque.peekFirst()];
        }

        return res;
    }


    // 又是暴力ETL废了。。
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int maxIdx = 0;
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        res.add(max);

        for (int r = k; r < nums.length; r++) {
            // 当前值
            int current = nums[r];

            // 如果上一个窗口内的最大值被移出
            if ((r - k) == maxIdx) {
                max = current;
                maxIdx = r;
                for (int i = k; i > 0 && k > 1; i--) {
                    if (nums[r-i+1] > max) {
                        max = nums[r-i+1];
                        maxIdx = r-i+1;
                    }
                }
            } else if (current > max) {
                max = current;
                maxIdx = r;
            }
            res.add(max);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
