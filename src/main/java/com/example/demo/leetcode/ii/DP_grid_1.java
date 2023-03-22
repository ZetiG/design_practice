package com.example.demo.leetcode.ii;


import akka.japi.Pair;

/**
 * Description: 1139. 最大的以 1 为边界的正方形
 *
 *  给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-1-bordered-square
 *
 * @author Zeti
 * @date 2023/2/17 09:42
 */
public class DP_grid_1 {
    public static void main(String[] args) {
        //  1   1   1
        //  1   0   1
        //  1   1   1
        int[][] g1 = {{1,1,1},{1,0,1},{1,1,1}};
        System.err.println(9 == largest1BorderedSquare(g1));

        int[][] g2 = {{1,1,0,0}};
        System.err.println(1 == largest1BorderedSquare(g2));

    }

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rs = new int[m][n + 1], cs = new int[n][m + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                rs[i][j + 1] = rs[i][j] + grid[i][j]; // 每行的前缀和
                cs[j][i + 1] = cs[j][i] + grid[i][j]; // 每列的前缀和
            }
        for (int d = Math.min(m, n); d > 0; --d) // 从大到小枚举正方形边长 d
            for (int i = 0; i <= m - d; ++i)
                for (int j = 0; j <= n - d; ++j) // 枚举正方形左上角坐标 (i,j)
                    if (rs[i][j + d] - rs[i][j] == d && // 上边
                            cs[j][i + d] - cs[j][i] == d && // 左边
                            rs[i + d - 1][j + d] - rs[i + d - 1][j] == d && // 下边
                            cs[j + d - 1][i + d] - cs[j + d - 1][i] == d)   // 右边
                        return d * d;
        return 0;
    }

    public static int largest1BorderedSquare2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        Pair<Integer, Integer>[][] dp = new Pair[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = new Pair<>(0, 0);
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(grid[i - 1][j - 1] == 0) {
                    dp[i][j] = new Pair<>(0, 0);
                } else {
                    dp[i][j] = new Pair<>(dp[i][j - 1].first() + 1, dp[i - 1][j].second() + 1);
                }
            }
        }

        int ans = 0;
        for(int i = m; i > 0; i--){
            for(int j = n; j > 0; j--){
                if(dp[i][j].first() != 0 && dp[i][j].second() != 0){
                    int tmp = Math.min(dp[i][j].first(), dp[i][j].second());
                    for(int len = tmp; len > 0; len--){
                        int x = i - len + 1, y = j - len + 1;
                        if(dp[x][j].first() >= len && dp[i][y].second() >= len) ans = Math.max(ans, len * len);
                    }
                }
            }
        }
        return ans;
    }

}
