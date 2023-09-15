package com.example.demo.leetcode.i;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 94. 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author Zeti
 * @date 2023/9/15 10:45
 */

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode td8 = new TreeNode(8);
        TreeNode td7 = new TreeNode(7);
        TreeNode td6 = new TreeNode(6);
        TreeNode td5 = new TreeNode(5, td7, td8);
        TreeNode td4 = new TreeNode(4);
        TreeNode td3 = new TreeNode(3, null, td6);
        TreeNode td2 = new TreeNode(2, td4, td5);
        TreeNode td1 = new TreeNode(1, td2, td3);

        System.err.println(inorderTraversal(td1));

    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
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
