package com.example.demo.leetcode.i;

/**
 * Description: 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author Zeti
 * @date 2023/9/19 18:07
 */
public class InvertTree {
    public static void main(String[] args) {
        // [4,2,7,1,3,6,9]
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn7 = new TreeNode(7, tn6, tn9);
        TreeNode tn2 = new TreeNode(2, tn1, tn3);
        TreeNode tn4 = new TreeNode(4, tn2, tn7);
        System.err.println(invertTree(tn4));

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left != null || root.right != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left= tmp;
        }

        invertTree(root.left);
        invertTree(root.right);
        return root;
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
