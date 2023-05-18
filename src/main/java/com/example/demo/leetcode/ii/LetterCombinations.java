package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description: 17. 电话号码的字母组合 
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *  "2", "abc",
 *  "3", "def",
 *  "4", "ghi",
 *  "5", "jkl",
 *  "6", "mno",
 *  "7", "pqrs",
 *  "8", "tuv",
 *  "9", "wxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 *
 * @author Zeti
 * @date 2023/5/18 10:09
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String s1 = "23";
        System.err.println(letterCombinations(s1)); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String s2 = "";
        System.err.println(letterCombinations(s2)); // []

        String s3 = "2";
        System.err.println(letterCombinations(s3)); // ["a","b","c"]

        String s4 = "89";
        System.err.println(letterCombinations(s4)); // [tw, tx, ty, tz, uw, ux, uy, uz, vw, vx, vy, vz]

        String s5 = "789";
        System.err.println(letterCombinations(s5)); // [ptw, ptx, pty, ptz, puw, pux, puy, puz, pvw, pvx, pvy, pvz, qtw, qtx, qty, qtz, quw, qux, quy, quz, qvw, qvx, qvy, qvz, rtw, rtx, rty, rtz, ruw, rux, ruy, ruz, rvw, rvx, rvy, rvz, stw, stx, sty, stz, suw, sux, suy, suz, svw, svx, svy, svz]

    }

    // 回溯
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        Map<String, String> map = Map.of(
                "2", "abc",
                "3", "def",
                "4", "ghi",
                "5", "jkl",
                "6", "mno",
                "7", "pqrs",
                "8", "tuv",
                "9", "wxyz"
        );

        // 主逻辑入口
        String[] split = digits.split("");
        backtrack(map, split, 0, map.get(split[0]), new StringBuilder(), res);
        return res;
    }

    // 回溯主逻辑，回溯的本质是递归，但是回溯和递归的区别就在于：回溯可回退到上一步，然后修改路线重新向下执行
    private static void backtrack(Map<String, String> map, String[] split, int arrIdx, String str, StringBuilder builder, List<String> res) {
        arrIdx = arrIdx + 1;

        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            if (arrIdx >= split.length) {
                res.add(builder.toString());    // 记录结果值
                builder.deleteCharAt(builder.length()-1);   // 回溯结果值(已被保存，当前引用地址可返回上一步)
                continue;
            }
            backtrack(map, split, arrIdx, map.get(split[arrIdx]), builder, res);

        }

        // 下面这两步是为了返回上一层（倒退一步），然后向后移动坐标，再继续往下处理
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length()-1);
        }
        arrIdx = arrIdx-1;
    }

}
