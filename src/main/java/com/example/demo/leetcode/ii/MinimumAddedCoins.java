package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 2952. 需要添加的硬币的最小数量
 *
 *  给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 *  如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 *  返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 *  数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 *
 * @author Zeti
 * @date 2024/4/1 15:15
 */
public class MinimumAddedCoins {
    public static void main(String[] args) {
        int[] c1 = {1,4,10}; int t1 = 19;
        System.err.println(minimumAddedCoins(c1, t1));  // 2, [2,8]

        int[] c2 = {1,4,10,5,7,19}; int t2 = 19;
        System.err.println(minimumAddedCoins(c2, t2));  // 1, [2]

        int[] c3 = {1,1,1}; int t3 = 20;
        System.err.println(minimumAddedCoins(c3, t3));  // 3, [4,8,16]

    }

    public static int minimumAddedCoins(int[] coins, int target) {
        int maxVal = target + 1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[target] != maxVal ? dp[target] : -1;
    }

    //     1 2 3 4 5 6 7 8 9
    // 10
    // 4
    // 2
    // 1
    public static int minimumAddedCoins2(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0;
        int x = 1;
        int length = coins.length, index = 0;
        while (x <= target) {
            if (index < length && coins[index] <= x) {
                x += coins[index];
                index++;
            } else {
                x *= 2;
                ans++;
            }
        }
        return ans;
    }

}
