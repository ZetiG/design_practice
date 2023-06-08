package com.example.demo.leetcode.i;

import java.util.Stack;

/**
 * Description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 *
 * @author Zeti
 * @date 2023/6/8 11:10
 */
public class IsValid {
    public static void main(String[] args) {
        String s1 = "()";
        System.err.println(isValid(s1));

        String s2 = "()[]{}";
        System.err.println(isValid(s2));

        String s3 = "(]";
        System.err.println(isValid(s3));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            // 查看栈顶元素，但不移出它
            Character peek = stack.peek();
            if (peek.equals('(') && c == ')') {
                stack.pop();
            } else if (peek.equals('[') && c == ']') {
                stack.pop();
            } else if (peek.equals('{') && c == '}') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

}
