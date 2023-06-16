package com.example.demo.leetcode.iii;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 994. 腐烂的橘子 
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 *
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotting-oranges
 *
 * @author Zeti
 * @date 2023/6/14 10:49
 */
public class OrangesRotting {
    public static void main(String[] args) {
        int[][] g1 = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.err.println(orangesRotting(g1)); // 4

        int[][] g2 = {{2,1,1}, {0,1,1}, {1,0,1}};
        System.err.println(orangesRotting(g2)); // -1

        int[][] g3 = {{0,2}};
        System.err.println(orangesRotting(g3)); // 0

        int[][] g4 = {{0,2,2}};
        System.err.println(orangesRotting(g4)); // 0

    }

    // 2 1 1
    // 0 1 1
    // 1 0 1
    public static int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();

        // 先将所有腐烂的🍊加入队列，待后续处理
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                }
            }
        }
        // 定义上下左右移动的坐标
        int[][] p1 = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int steps = 0;  // 计时结果

        // 处理腐烂的🍊
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] temp = deque.poll();

                // 当前腐烂的🍊进行上下左右延伸腐烂
                for (int j = 0; j < p1.length; j++) {
                    int x = temp[0] + p1[j][0];
                    int y = temp[1] + p1[j][1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        deque.offer(new int[]{x, y});
                    }
                }
            }
            // 一轮下来，如果队列里还有未处理的腐烂🍊则计时+1
            if (!deque.isEmpty()) {
                steps++;
            }
        }

        // 处理完腐烂的🍊后，需要重新遍历数组，看是否存在无法被腐烂的🍊
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return steps;
    }


}
