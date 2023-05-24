package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author Zeti
 * @date 2023/5/24 10:04
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n0 = 0;
        System.err.println(generateParenthesis(n0));

        int n1 = 1;
        System.err.println(generateParenthesis(n1));

        int n2 = 2;
        System.err.println(generateParenthesis(n2));

        int n3 = 3;
        System.err.println(generateParenthesis(n3));


    }

    // () () ()
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }

    private static void dfs(int left, int right, String curStr, List<String> res) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(", res);
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")", res);
        }
    }



}
