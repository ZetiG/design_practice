package com.example.demo.leetcode.iii;

import java.util.Stack;

/**
 * Description: 接雨水—多解法
 *
 * @author Zeti
 * @date 2022/3/3 5:14 PM
 */
public class Rain_DP {

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {0, 4, 2, 0, 3, 2, 5, 3};

        // stack
        System.err.println(stack(arr1));
        System.err.println(stack(arr2));

        // DP
        System.err.println(trap(arr1));
        System.err.println(trap(arr2));
    }

    public static int stack(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }

        int total = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < arr.length; i++) {

            // 当前遍历的值，大于栈顶数据，也就是说右边墙高于左边墙，这样才能存水
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {

                // 如果左边墙(当前左边墙有可能是最低洼处)从栈内弹出，且还存在另外的左边墙，则能存水
                // 若弹出后 不存在其他左边墙，则无法存水
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int leftIdx = stack.peek();
                int leftHeight = arr[leftIdx];    // 左边高度
                int rightHeight = arr[i]; // 右边高度
                int bottomHeight = arr[pop];  // 最低洼处

                // 当前左右两边可存水量 = {右边墙下标 - 左边墙下标 - 1(因为是下标，存水量需要去掉左右两边墙的下标) * （左右两边墙的最低处 - 中间最低洼处）}
                total += (i - leftIdx - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);

            }

            stack.push(i);

        }

        return total;
    }


    /**
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        //  {0, 4, 2, 0, 3, 2, 5, 3};
        // 正向遍历数组 height 得到数组 leftMax 的每个元素值
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 反向遍历数组 height 得到数组 rightMax 的每个元素值
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // 遍历每个下标位置即可得到能接的雨水总量
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


}
