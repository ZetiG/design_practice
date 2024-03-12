package com.example.demo.leetcode.i;

/**
 * Description: 2129. 将标题首字母大写
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 *
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title
 *
 * @author Zeti
 * @date 2024/3/12 10:05
 */
public class CapitalizeTitle {
    public static void main(String[] args) {

        String t1 = "capiTalIze tHe titLe";
        System.err.println(capitalizeTitle(t1)); // "Capitalize The Title"

        String t2 = "First leTTeR of EACH Word";
        System.err.println(capitalizeTitle(t2)); // "First Letter of Each Word"

        String t3 = "i lOve leetcode";
        System.err.println(capitalizeTitle(t3)); // "i Love Leetcode"


    }

    public static String capitalizeTitle(String title) {
        StringBuilder builder = new StringBuilder();
        for (String str : title.split(" ")) {
            if (builder.length() > 0) {
                builder.append(" ");
            }

            if (str.length() > 2) {
                builder.append(str.substring(0, 1).toUpperCase());
                str = str.substring(1);
            }
            builder.append(str.toLowerCase());
        }
        return builder.toString();
    }

        public static String capitalizeTitle2(String title) {
        title = title.toLowerCase();

        String[] split = title.split(" ");
        title = "";
        for (int i = 0; i < split.length; i++) {
            if (i > 0) {
                title = title + " ";
            }
            if (split[i].length() > 2) {
                String str = split[i];
                title = title + str.substring(0, 1).toUpperCase() + str.substring(1);
                continue;
            }
            title = title + split[i];
        }
        return title;
    }

}
