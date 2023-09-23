package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *  1. 节点的左子树只包含 小于 当前节点的数。
 *  2. 节点的右子树只包含 大于 当前节点的数。
 *  3. 所有左子树和右子树自身必须也是二叉搜索树
 *
 * @author Zeti
 * @date 2023/9/23 16:58
 */
public class IsValidBST {
    public static void main(String[] args) {
        // root = [2,1,3] // 输出：true
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2, t2, t3);
        System.err.println(isValidBST(t1));

        // root = [5,1,4,null,null,3,6] // 输出：false
        TreeNode t_5 = new TreeNode(6);
        TreeNode t_4 = new TreeNode(3);
        TreeNode t_3 = new TreeNode(4, t_4, t_5);
        TreeNode t_2 = new TreeNode(1);
        TreeNode t_1 = new TreeNode(5, t_2, t_3);
        System.err.println(isValidBST(t_1));

        // [5,4,6,null,null,3,7] // false
        TreeNode td5 = new TreeNode(7);
        TreeNode td4 = new TreeNode(3);
        TreeNode td3 = new TreeNode(6, td4, td5);
        TreeNode td2 = new TreeNode(4);
        TreeNode td1 = new TreeNode(5, td2, td3);
        System.err.println(isValidBST(td1));

        // [32,26,47,19,null,null,56,null,27] // false
        TreeNode td_6 = new TreeNode(56);
        TreeNode td_5 = new TreeNode(27);
        TreeNode td_4 = new TreeNode(19, null, td_5);
        TreeNode td_3 = new TreeNode(47, null, td_6);
        TreeNode td_2 = new TreeNode(26,td_4, null);
        TreeNode td_1 = new TreeNode(32, td_2, td_3);
        System.err.println(isValidBST(td_1));

    }

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double tmp = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= tmp) {
                return false;
            }
            tmp = root.val;
            root = root.right;
        }
        return true;
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
