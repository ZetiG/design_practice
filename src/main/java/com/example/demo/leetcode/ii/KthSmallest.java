package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 *
 * 二叉搜索树具有如下性质：
 *  1. 结点的左子树只包含小于当前结点的数。
 *  2. 结点的右子树只包含大于当前结点的数。
 *  3. 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Zeti
 * @date 2023/9/23 13:48
 */
public class KthSmallest {
    public static void main(String[] args) {
        // root = [3,1,4,null,2], k = 1  // 输出：1

        TreeNode t4 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1, null, t4);
        TreeNode t1 = new TreeNode(3, t2, t3);
        int k1 = 1;
        System.err.println(kthSmallest(t1, k1));

        // root = [5,3,6,2,4,null,null,1], k = 3  // 输出：3
        TreeNode t_6 = new TreeNode(1);
        TreeNode t_5 = new TreeNode(4);
        TreeNode t_4 = new TreeNode(2, t_6, null);
        TreeNode t_3 = new TreeNode(6);
        TreeNode t_2 = new TreeNode(3, t_4, t_5);
        TreeNode t_1 = new TreeNode(5, t_2, t_3);
        int k2 = 3;
        System.err.println(kthSmallest(t_1, k2));

    }

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
           while (root != null) {
               stack.push(root);
               root = root.left;
           }
            root = stack.pop();
           --k;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }



    static class TreeNode {
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