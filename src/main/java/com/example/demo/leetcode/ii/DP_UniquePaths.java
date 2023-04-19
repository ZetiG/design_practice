package com.example.demo.leetcode.ii;

/**
 * Description: 62. 不同路径 
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/19 11:25
 */
public class DP_UniquePaths {
    public static void main(String[] args) {
        int m1 = 3, n1 = 7;
        System.err.println(uniquePaths(m1, n1));    // 输出：28

        int m2 = 3, n2 = 2;
        System.err.println(uniquePaths(m2, n2));    // 输出：3

        int m3 = 7, n3 = 3;
        System.err.println(uniquePaths(m3, n3));    // 输出：28

        int m4 = 3, n4 = 3;
        System.err.println(uniquePaths(m4, n4));    // 输出：6

    }

    // 组合数学
    // 从左上角到右下角的过程中，我们需要移动 m+n−2 次，其中有 m−1 次向下移动，n−1 次向右移动
    // 机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走不就行了吗？即C（（m+n-2），（m-1））。
    public static int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    // 递推公式：f(n) = f(m-1)(n) + f(m)(n-1)
    // 0   0   0   0
    // 0   1   _   _
    // 0   _   _   _
    // 0   _   _   _
    public static int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;

        for (int i = 1; i < dp.length; i++) {
            int[] its = dp[i];
            for (int j = 1; j < its.length; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }

}
