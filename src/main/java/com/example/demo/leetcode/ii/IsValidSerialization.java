package com.example.demo.leetcode.ii;

/**
 * Description: 331. 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的
 *      例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 注意：不允许重建树。
 *
 * @author Zeti
 * @date 2024/4/1 11:39
 */
public class IsValidSerialization {
    public static void main(String[] args) {
//        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        System.err.println(isValidSerialization(s1));   // true
//
//        String s2 = "1,#";
//        System.err.println(isValidSerialization(s2));   // false
//
//        String s3 = "9,#,#,1";
//        System.err.println(isValidSerialization(s3));   // false

        String s4 = "9,#,92,#,#";
        System.err.println(isValidSerialization(s4));   // true


    }

    public static boolean isValidSerialization(String preorder) {
        int slot = 1; // 初始槽位，根节点只会有一个
        int i = 0;
        while (i < preorder.length()) {
            if (slot <= 0) {
                return false;
            }

            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slot--;
                i++;
            } else {
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                slot++;
            }
        }
        return slot == 0;
    }



}
