package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2696. 删除子串后的字符串最小长度
 *  给你一个仅由 大写 英文字符组成的字符串 s 。
 *  你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 *  通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 *
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 *
 * @author Zeti
 * @date 2024/1/10 09:14
 */
public class MinLength {
    public static void main(String[] args) {
        String s1 = "ABFCACDB";
        System.err.println(minLength(s1));   // 2

        String s2 = "ACBBD";
        System.err.println(minLength(s2));   // 5

    }

    // 栈；依次入栈，入栈前取栈顶元素和当前元素判断是否为'AB'或'CD'，并弹出
    public static int minLength(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character at : s.toCharArray()) {
            if (!deque.isEmpty() && ((deque.peek() == 'A' && at == 'B') || (deque.peek() == 'C' && at == 'D'))) {
                deque.pop();
            } else {
                deque.push(at);
            }
        }
        return deque.size();
    }


    // 投机取巧，字符串替换
    public static int minLength2(String s) {
        while(s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }
        return s.length();
    }

}
