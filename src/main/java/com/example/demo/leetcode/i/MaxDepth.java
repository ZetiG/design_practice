package com.example.demo.leetcode.i;


/**
 * Description: 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author Zeti
 * @date 2023/9/15 16:06
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode td8 = new TreeNode(8);
        TreeNode td7 = new TreeNode(7);
        TreeNode td6 = new TreeNode(6);
        TreeNode td5 = new TreeNode(5, td7, td8);
        TreeNode td4 = new TreeNode(4);
        TreeNode td3 = new TreeNode(3, null, td6);
        TreeNode td2 = new TreeNode(2, td4, td5);
        TreeNode td1 = new TreeNode(1, td2, td3);

        System.err.println(maxDepth(td1));

    }

    //        1
    //    2      3
    //  4   5      6
    //    7   8
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxHeight = maxDepth(root.left);
        int rightMaxHeight = maxDepth(root.right);
        return Math.max(leftMaxHeight, rightMaxHeight) + 1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
