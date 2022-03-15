package com.example.demo.leetcode.i;


import java.util.ArrayList;
import java.util.List;

/**
 * Description: 二叉树
 *
 * @author Zeti
 * @date 2022/3/15 5:31 PM
 */
public class BinaryTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,2,3};
        TreeNode node = new TreeNode();
        node.val = 1;

        TreeNode nodeL = new TreeNode();
        nodeL.val = 0;

        TreeNode nodeR = new TreeNode();
        nodeR.val = 2;
        node.left = nodeL;
        node.right = nodeR;

        List<Integer> integers = inorderTraversal(node);
        System.err.println(integers);

    }

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
     * <p>
     * ps1: 输入：root = [1,null,2,3]  输出：[1,3,2]
     * ps2: 输入：root = [1,2]         输出：[2,1]
     * ps3: 输入：root = []            输出：[]
     * ps4: 输入：root = [1,null,2]    输出：[1,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    // 递归
    private static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
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
