package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2810. 故障键盘
 *
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * 返回最终笔记本屏幕上输出的字符串。
 *
 * @author Zeti
 * @date 2024/4/1 10:12
 */
public class FinalString {
    public static void main(String[] args) {
        String s = "aaiibbicciiiddiiiiee";
        System.err.println(finalString(s));
    }

    public static String finalString(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean tail = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail; // 修改添加方向
            } else if (tail) {
                q.addLast(c); // 加尾部
            } else {
                q.addFirst(c); // 加头部
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();
    }


    public static String finalString2(String s) {
        String all = s.replaceAll("ii", "");
        String[] strings = all.split("i");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(strings[i]);
            if (i == strings.length-1 && !all.endsWith("i")) {
                break;
            }
            builder.reverse();
        }
        return builder.toString();
    }
}
