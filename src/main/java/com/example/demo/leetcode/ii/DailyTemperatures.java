package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: 739. 每日温度
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 *
 * @author Zeti
 * @date 2023/5/31 17:51
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] n1 = {73,74,75,71,69,72,76,73};
        System.err.println(Arrays.toString(dailyTemperatures(n1))); // [1,1,4,2,1,1,0,0]

        int[] n2 = {30,40,50,60};
        System.err.println(Arrays.toString(dailyTemperatures(n2))); // [1,1,1,0]

        int[] n3 = {30,60,90};
        System.err.println(Arrays.toString(dailyTemperatures(n3))); // [1,1,0]

    }

    // 单调栈，每次入栈和栈顶元素比较，存入较大的那个下标，并计算移出元素和入栈元素的下标差即为移出元素的结果值
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    // 73,74,75,71,69,72,76,73
    // 0  1  2  -2 -4 -1 3 0    -- 前缀差的和
    // 1  1  4  2  1  1  0 0    -- 根据前缀和数组，求出（右边-当前位置>0的下标差）
    // 超时解
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[0] = 0;
        for (int i = 1; i < temperatures.length; i++) {
            res[i] += res[i-1] + (temperatures[i] - temperatures[i-1]);
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = i+1; j <= res.length; j++) {
                if (j == res.length) {
                    res[i] = 0;
                    break;
                }
                if (res[j] - res[i] > 0) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

}
