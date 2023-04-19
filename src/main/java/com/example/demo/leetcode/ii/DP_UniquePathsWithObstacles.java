package com.example.demo.leetcode.ii;

/**
 * Description: 63. 不同路径 II 
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/19 12:01
 */
public class DP_UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] o1 = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.err.println(uniquePathsWithObstacles(o1)); // 2

        int[][] o2 = {{0,1}, {0,0}};
        System.err.println(uniquePathsWithObstacles(o2)); // 1


    }

    // obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    //输出：2
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];

        for (int i = 1; i < dp.length; i++) {
            int[] its = dp[i];
            for (int j = 1; j < its.length; j++) {
                if (i == 1 && j == 1) {
                    if (obstacleGrid[i-1][i-1] == 1) {
                        return 0;
                    }
                    dp[1][1] = 1;
                    continue;
                }

                if (obstacleGrid[i-1][j-1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
