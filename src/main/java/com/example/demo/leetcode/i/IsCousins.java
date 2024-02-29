package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false
 *
 * @author Zeti
 * @date 2024/2/29 09:37
 */
public class IsCousins {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.err.println(isCousins(t1, 4, 3));    // false

        TreeNode t_5 = new TreeNode(5);
        TreeNode t_3 = new TreeNode(3, null, t_5);
        TreeNode t_4 = new TreeNode(4);
        TreeNode t_2 = new TreeNode(2, null, t_4);
        TreeNode t_1 = new TreeNode(1, t_2, t_3);
        System.err.println(isCousins(t_1, 5, 4));    // true

        TreeNode tt_3 = new TreeNode(3);
        TreeNode tt_4 = new TreeNode(4);
        TreeNode tt_2 = new TreeNode(2, null, tt_4);
        TreeNode tt_1 = new TreeNode(1, tt_2, tt_3);
        System.err.println(isCousins(tt_1, 2, 3));    // false

    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        boolean bx = false, by = false;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int size = deque.size();

        while (size > 0) {
            TreeNode pop = deque.pop();
            size--;
            if (pop.left != null) {
                deque.add(pop.left);
            }
            if (pop.right != null) {
                deque.add(pop.right);
            }
            if (pop.left != null && pop.right != null && ((pop.left.val == x && pop.right.val == y) || (pop.left.val == y && pop.right.val == x))) {
                return false;
            }

            if (pop.val == x) {
                bx = true;
            }
            if (pop.val == y) {
                by = true;
            }
            if (bx && by) {
                return true;
            }

            if (size == 0) {
                size = deque.size();
                bx = false;
                by = false;
            }
        }
        return false;
    }


    public static class TreeNode {
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
