package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

/**
 * Description: 2645. 构造有效字符串的最少插入数
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 *
 *  1 <= word.length <= 50
 *  word 仅由字母 "a"、"b" 和 "c" 组成。
 *
 * @author Zeti
 * @date 2024/1/11 16:31
 */
public class AddMinimum {
    public static void main(String[] args) {

        String w1 = "b";
        System.err.println(addMinimum(w1));   // 2

        String w2 = "aaa";
        System.err.println(addMinimum(w2));   // 6

        String w3 = "abc";
        System.err.println(addMinimum(w3));   // 0

        String w4 = "aabbccccb";
        System.err.println(addMinimum(w4));   // 12

        String w5 = "aaaaac";
        System.err.println(addMinimum(w5));   // 9

        String w6 = "acacc";
        System.err.println(addMinimum(w6));   // 4


    }

    // 高效
    public static int addMinimum(String word) {
        int n = word.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt * 3 - n;
    }


    // 执行：2ms
    // 栈，每次遍历一个字符时，判断栈顶字符跟当前字符是否相邻
    public static int addMinimum2(String word) {
        int len = word.length();
        int res = 0;

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char at = word.charAt(i);
            char peek = Optional.ofNullable(deque.peek()).orElse('c');
            if (at == 'a') {
                res += 'c' - peek;
            } else if (at == 'b') {
                if (peek != 'a') {
                    res += 'c' - peek + 1;
                }
            } else if (at == 'c') {
                if (peek > 'b') {
                    res += 'c' - peek + 2;
                } else if (peek < 'b') {
                    res += 'c' - peek - 1;
                }
            }
            deque.push(at);
        }

        if (!deque.isEmpty() && deque.peek() != 'c') {
            res += 'c' - deque.peek();
        }

        return res;
    }

}
