package com.example.demo.leetcode.i;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author Zeti
 * @date 2023/9/20 16:56
 */
public class IsSymmetric {
    public static void main(String[] args) {
        // [1,2,2,3,4,4,3]  true
        TreeNode tn7 = new TreeNode(3);
        TreeNode tn6 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(4);
        TreeNode tn4 = new TreeNode(3);
        TreeNode tn3 = new TreeNode(2, tn6, tn7);
        TreeNode tn2 = new TreeNode(2, tn4, tn5);
        TreeNode tn1 = new TreeNode(1, tn2, tn3);
        System.err.println(isSymmetric(tn1));

        // [1,2,2,null,3,null,3]  false
        TreeNode tn_5 = new TreeNode(3);
        TreeNode tn_4 = new TreeNode(3);
        TreeNode tn_3 = new TreeNode(2, null, tn_5);
        TreeNode tn_2 = new TreeNode(2, null, tn_4);
        TreeNode tn_1 = new TreeNode(1, tn_2, tn_3);
        System.err.println(isSymmetric(tn_1));
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);    // 方法1 递归
//        return check2(root, root);    // 方法2 迭代
    }

    // 递归
    public static boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null) {
            return false;
        }

        if (l.val == r.val) {
            return check(l.left, r.right) && check(l.right, r.left);
        }
        return false;
    }

    // 迭代
    public static boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
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
