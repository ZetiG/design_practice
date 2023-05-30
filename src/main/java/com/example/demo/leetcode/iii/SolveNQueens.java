package com.example.demo.leetcode.iii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description: 51. N 皇后 
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 总结：目标不能在同一行同一列同斜线
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 *
 * @author Zeti
 * @date 2023/5/30 10:28
 */
public class SolveNQueens {
    public static void main(String[] args) {
        int n0 = 0;
        solveNQueens(n0);   // 0

        int n1 = 1;
        solveNQueens(n1);   // 1

        int n2 = 2;
        solveNQueens(n2);   // 0

        int n3 = 3;
        solveNQueens(n3);   // 0

        int n4 = 4;
        solveNQueens(n4);   // 2

    }

    // 0 N 0 0
    // 0 0 0 N
    // N 0 0 0
    // 0 0 N 0

    // 0 0 N 0
    // N 0 0 0
    // 0 0 0 N
    // 0 N 0 0

    // 主程序入口，流程处理
    public static List<List<String>> solveNQueens(int n) {
        // 伪结果集，存放满足条件的左边点，int[i,j] i是横坐标，j是纵坐标
        List<List<int[]>> res = new ArrayList<>();
        // 回溯时临时存放队列
        Deque<int[]> deque = new ArrayDeque<>();
        // 回溯
        backtracking(n, 0, deque, res);

        // 将伪结果转换成题目要求的结果
        return generatorResult(res);
    }

    // 回溯判断满足条件的坐标，并存入集合； iIdx:当前遍历到的横行数
    private static void backtracking(int n, int iIdx, Deque<int[]> deque, List<List<int[]>> res) {
        // 当iIdx==n时，代表已遍历完nxn的数组
        if (iIdx == n) {
            // 且队列里的坐标数==n；代表此次回溯结果有效；存入伪结果集
            if (deque.size() == n) {
                res.add(new ArrayList<>(deque));
            }
            return;
        }

        for (int i = iIdx; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 校验[i,j]坐标是否满足题意
                if (check(new ArrayList<>(deque), i, j)) {
                    deque.addLast(new int[]{i,j});
                    backtracking(n, i+1, deque, res);
                   deque.removeLast();
                }
            }
            // 如果当前行遍历完成，且队列里的结果数量小于当前遍历完的行数，代表此次回溯结果不满足，返回上一步
            if (deque.size() < i+1) {
                return;
            }
        }
    }

    // 校验当前坐标点是否满足题目要求，跟已存在的坐标不在同一横向、纵向、斜向的要求
    private static boolean check(List<int[]> res, int i, int j) {
        for (int[] re : res) {
            int left = re[0];
            int right = re[1];

            // 同行、同列
            if (i == left || j == right) {
                return false;
            }

            // 同斜向，左下、右下
            if ((i-left==j-right) || (i-left==right-j)) {
                return false;
            }
        }
        return true;
    }

    // 对回溯的结果集进行转换为题目要求的目标数组
    private static List<List<String>> generatorResult(List<List<int[]>> arr) {
        List<List<String>> res = new ArrayList<>();
        for (List<int[]> its : arr) {
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < its.size(); i++) {
                int i1 = its.get(i)[1];
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < its.size(); j++) {
                    if (j == i1) {
                        builder.append("Q");
                        continue;
                    }
                    builder.append(".");
                }
                strs.add(builder.toString());
            }
            res.add(strs);
        }
        return res;
    }

}
