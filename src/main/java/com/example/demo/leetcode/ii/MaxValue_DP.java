package com.example.demo.leetcode.ii;

/**
 * Description: 剑指 Offer 47. 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * @author Zeti
 * @date 2023/3/8 15:54
 */
public class MaxValue_DP {

    public static void main(String[] args) {
        // [
        //  [1,3,1],
        //  [3,5,1],
        //  [4,2,1]
        //  ]
//        int[][] m1 = {{1,3,1}, {1,5,1}, {4,2,1}};
//        System.err.println(maxValue(m1));

        int[][] m2 = {{1,3,4,5}, {3,4,5,2}, {6,2,4,1}};
        System.err.println(maxValue(m2));

    }


    // 1 3 4 5
    // 3 4 5 2
    // 6 2 4 1

    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                grid[i][0] += grid[i-1][0];
            }
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.max(grid[i][j-1], grid[i-1][j]);
                } else if (j > 0) {
                    grid[i][j] += grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }





        // 转移方程推导
    // 向右走，f(i,j) ← f(i−1,j) + grid(i,j)
    // 向下走，f(i,j) ← f(i,j-1) + grid(i,j)
    // f(i, j) = max{f(i - 1, j), f(i, j - 1)} + grid[i][j]
    public static int maxValue2(int[][] grid) {
        int m = grid.length, n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int mx = 0;
                if (i > 0) {
                    mx = grid[i-1][j];
                }
                if (j > 0 && grid[i][j-1] > mx) {
                    mx = grid[i][j-1];
                }
                grid[i][j] += mx;
            }
        }
        return grid[m-1][n-1];
    }



}
