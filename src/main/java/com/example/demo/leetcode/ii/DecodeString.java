package com.example.demo.leetcode.ii;

import java.util.Stack;

/**
 * Description: 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author Zeti
 * @date 2024/10/21 10:16
 */
public class DecodeString {

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        System.err.println(decodeString(s1));   // aaabcbc

        String s2 = "a3[b2[c]]d";
        System.err.println(decodeString(s2));   // abccbccbccd

        String s3 = "2[abc]3[cd]ef";
        System.err.println(decodeString(s3));   // abcabccdcdcdef

        String s4 = "abc3[cd]xyz";
        System.err.println(decodeString(s4));   // abccdcdcdxyz

        String s5 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.err.println(decodeString(s5));   // "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"

    }

    // 双栈法
    public static String decodeString(String s) {
        // 栈用于存储重复次数
        Stack<Integer> countStack = new Stack<>();
        // 栈用于存储当前的字符串
        Stack<StringBuilder> stringStack = new Stack<>();

        // 当前处理的字符串
        StringBuilder currentStr = new StringBuilder();
        // 用于记录数字
        int count = 0;

        for (char cr : s.toCharArray()) {
            // 如果是数字，计算当前的倍数
            if (Character.isDigit(cr)) {
                count = count * 10 + (cr - '0');
            }
            // 如果是 '['，将当前字符串和倍数压入栈，并准备处理新内容
            else if (cr == '[') {
                countStack.push(count);
                stringStack.push(currentStr);
                currentStr = new StringBuilder();
                count = 0;  // 重置倍数
            }
            // 如果是 ']'，开始从栈中弹出对应倍数和前面部分的字符串
            else if (cr == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder previousStr = stringStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    previousStr.append(currentStr);
                }
                currentStr = previousStr;  // 处理后的部分替换当前字符串
            }
            // 否则就是正常字符，直接追加
            else {
                currentStr.append(cr);
            }
        }

        // 最终返回处理完成的字符串
        return currentStr.toString();
    }


    // 单栈法
    // 3[z] 2[ 2[y] pq 4[ 2[jk] e 1[f] ]]ef
    // zzz yy pq jkjkef jkjkef jkjkef jkjkef   yy pq jkjkef jkjkef jkjkef jkjkef ef
    // --- ---------------------------------   --------------------------------- --
    public static String decodeString2(String s) {
        Stack<String> stack = new Stack<>();

        for(Character cr : s.toCharArray()) {
            if(cr != ']') {
                stack.push(cr.toString());
                continue;
            }

            // 获取当前[]内的完整字符串，当遇到']'时，则开始向前追溯到第一个'['
            StringBuilder strs = new StringBuilder();
            while (true) {
                String pop = stack.pop();
                if (!pop.equals("[")) {
                    strs.insert(0, pop);
                    continue;
                }
                break;
            }

            // 获取当前[]前面的k，k有可能是多位数
            StringBuilder numStr = new StringBuilder();
            while (!stack.isEmpty()) {
                String peek = stack.peek();
                // 遇到第一个非数字的字符时，停止
                if (!isNumeric(peek)) {
                    break;
                }
                numStr.append(stack.pop());
            }

            // 将[]内完整的字符循环k次，并再次入栈
            int num = Integer.parseInt(String.valueOf(numStr.reverse()));
            for (int j = 0; j < num; j++) {
                stack.push(strs.toString());
            }
        }

        // 输出结果
        StringBuilder result = new StringBuilder();
        for (String s1 : stack) {
            result.append(s1);
        }

        return result.toString();
    }

    // 判断是否为数字
    public static boolean isNumeric(String str){
        for (int i = str.length(); --i >= 0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


}
