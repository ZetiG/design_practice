package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 95. 不同的二叉搜索树 II
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * @author Zeti
 * @date 2024/4/3 14:13
 */
public class GenerateTrees {
    public static void main(String[] args) {
        System.err.println(generateTrees(1));
        System.err.println(generateTrees(2));
        System.err.println(generateTrees(3));
        System.err.println(generateTrees(4));
        System.err.println(generateTrees(5));
        System.err.println(generateTrees(6));
        System.err.println(generateTrees(7));
        System.err.println(generateTrees(8));

    }

    public static List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private static List<TreeNode> build(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        // 遍历从1-n，依次作为根节点
        for (int i = start; i <= end; i++) {

            List<TreeNode> left = build(1, i - 1);
            List<TreeNode> right = build(i+1, end);

            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    list.add(root);
                }
            }
        }
        return list;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
