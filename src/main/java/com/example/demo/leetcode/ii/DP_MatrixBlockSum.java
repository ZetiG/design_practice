package com.example.demo.leetcode.ii;

/**
 * Description: 1314. 矩阵区域和 
 *  给你一个m x n的矩阵mat和一个整数 k ，请你返回一个矩阵answer，其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 *
 *  i - k <= r <= i + k,
 *  j - k <= c <= j + k 且
 *  (r, c)在矩阵内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matrix-block-sum
 *
 * @author Zeti
 * @date 2023/4/17 19:39
 */
public class DP_MatrixBlockSum {

    public static void main(String[] args) {

        int[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int k1 = 1;
        System.err.println(matrixBlockSum(m1, k1)); // [[12,21,16],[27,45,33],[24,39,28]]

        int[][] m2 = {{1,2,3},{4,5,6},{7,8,9}};
        int k2 = 2;
        System.err.println(matrixBlockSum(m2, k2)); // [[45,45,45],[45,45,45],[45,45,45]]


    }

    // i - k <= r <= i + k,
    // j - k <= c <= j + k 且
    // (r, c) 在矩阵内。

    // i 1 2 3      0 <= ? <= 2
    // i 4 5 6
    // i 7 8 9
    //   j j j
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;

        int[][] P = new int[m + 1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                P[i][j] = P[i - 1][j] + P[i][j - 1] - P[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = get(P, m, n, i + K + 1, j + K + 1) - get(P, m, n, i - K, j + K + 1) - get(P, m, n, i + K + 1, j - K) + get(P, m, n, i - K, j - K);
            }
        }
        return ans;
    }

    private static int get(int[][] pre, int m, int n, int x, int y) {
        x = Math.max(Math.min(x, m), 0);
        y = Math.max(Math.min(y, n), 0);
        return pre[x][y];
    }

}

//  ["NumMatrix","sumRegion","sumRegion","sumRegion"]
// [[[  [3,0,1,4,2],
//      [5,6,3,2,1],
//      [1,2,0,1,5],
//      [4,1,0,1,7],
//      [1,0,3,0,5]
//      ]],
// [2,1,4,3],
// [1,1,2,2],
// [1,2,2,4]]
