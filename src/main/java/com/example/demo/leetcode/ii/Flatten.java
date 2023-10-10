package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author Zeti
 * @date 2023/10/9 11:44
 */
public class Flatten {
    public static void main(String[] args) {
        // [1,2,5,3,4,null,6]
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, n2, n5);
        flatten(n1);

    }

    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

        // 递归前序遍历，借助数组存储读取的树，再遍历数组重组树
    public static void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        addList(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public static void addList(TreeNode td, List<TreeNode> list) {
        if (td == null) {
            return;
        }
        list.add(td);
        addList(td.left, list);
        addList(td.right, list);
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
