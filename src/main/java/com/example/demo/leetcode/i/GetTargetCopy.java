package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1379. 找出克隆二叉树中的相同节点
 *
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 * 请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。只能 返回对克隆树 cloned 中已有的节点的引用。
 *
 * @author Zeti
 * @date 2024/4/3 09:24
 */
public class GetTargetCopy {
    public static void main(String[] args) {
        // tree = [7,4,3,null,null,6,19], target = 3
        //输出: 3
        //解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。

        // tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
        //输出: 4

        TreeNode t5 = new TreeNode(19);
        TreeNode t4 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3, t4, t5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t1 = new TreeNode(7, t2, t3);

        TreeNode t_5 = new TreeNode(19);
        TreeNode t_4 = new TreeNode(6);
        TreeNode t_3 = new TreeNode(3, t_4, t_5);
        TreeNode t_2 = new TreeNode(4);
        TreeNode t_1 = new TreeNode(7, t_2, t_3);

        TreeNode targetCopy = getTargetCopy(t1, t_1, t3);
        System.err.println(targetCopy == t_3);


    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // dfs
       return dfs(original, cloned, target);

       // bfs
//        return bfs(original, cloned, target);
    }

    private static TreeNode dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) {
            return null;
        }
        if (target == original) {
            return cloned;
        }

        TreeNode res1 = getTargetCopy(original.left, cloned.left, target);
        if (null != res1) {
            return res1;
        }
        TreeNode res2 = getTargetCopy(original.right, cloned.right, target);
        if (null != res2) {
            return res2;
        }
        return null;
    }

    private static TreeNode bfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        deque1.offer(original);
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque2.offer(cloned);

        while (!deque1.isEmpty()) {
            TreeNode pop1 = deque1.pop();
            TreeNode pop2 = deque2.pop();
            if (pop1 == target) {
                return pop2;
            }

            if (pop1.left != null) deque1.offer(pop1.left);
            if (pop2.left != null) deque2.offer(pop2.left);

            if (pop1.right != null) deque1.offer(pop1.right);
            if (pop2.right != null) deque2.offer(pop2.right);

        }

        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
