package com.example.demo.leetcode.ii;

import java.util.*;

/**
 * Description: 199. 二叉树的右视图
 *
 * @author Zeti
 * @date 2023/9/27 17:38
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, null, t4);
        TreeNode t2 = new TreeNode(2, null, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.err.println(rightSideView(t1));  // [1,3,4]

        TreeNode t_2 = new TreeNode(3);
        TreeNode t_1 = new TreeNode(1, null, t_2);
        System.err.println(rightSideView(t_1));  // [1,3]

    }

    /**
     * 广度优先 - 二叉树的层序遍历
     */
    // 右视图不等于右节点
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) {
            q.push(root);
        }

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode peek = q.peek();
                if (peek.left != null) q.offer(peek.left);
                if (peek.right != null) q.offer(peek.right);
                if (n == 0) res.add(peek.val);
                q.pop();
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
