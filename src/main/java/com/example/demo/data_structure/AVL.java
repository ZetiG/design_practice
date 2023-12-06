package com.example.demo.data_structure;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description: 手撕AVL（自平衡二叉树）
 *
 * @author Zeti
 * @date 2023/9/21 16:00
 */
public class AVL {
    public static void main(String[] args) {
        // [1,null,2,null,3,null,4,null,null] =>> [2,1,3,null,null,null,4]
//        TreeNode tn4 = new TreeNode(4);
//        TreeNode tn3 = new TreeNode(3, null, tn4);
//        TreeNode tn2 = new TreeNode(2, null, tn3);
//        TreeNode tn1 = new TreeNode(1, null, tn2);
//        AVL avl1 = new AVL();
//        System.err.println(avl1.balanceBST(tn1));

        // right
        TreeNode tn_3 = new TreeNode(3);
        TreeNode tn_5 = new TreeNode(5);
        TreeNode tn_7 = new TreeNode(7, null, tn_5);
        TreeNode tn_6 = new TreeNode(6, tn_7, tn_3);

        // left
        TreeNode tn_4 = new TreeNode(4);
        TreeNode tn_8 = new TreeNode(8, null, tn_4);

        // root
        TreeNode tn_13 = new TreeNode(13, tn_8, tn_6);

        AVL avl2 = new AVL();
        System.err.println(avl2.balanceBST(tn_13));

    }

    /**
     * 使用AVL【插入】和【旋转】代码 实现将一个【二叉查找树】转换为【平衡二叉查找树】
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null){
            return null;
        }
        // node节点的高度缓存
        Map<TreeNode,Integer> nodeHeight = new HashMap<>();
        TreeNode newRoot = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 先序遍历插入（其实用哪个遍历都行）
        while(node != null || !stack.isEmpty()){
            if (node != null){
                // 新树插入
                newRoot = insert(newRoot,node.val,nodeHeight);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
        return newRoot;
    }

    /**
     * 新节点插入
     * @param root root
     * @param val 新加入的值
     * @param nodeHeight 节点高度缓存
     * @return 新的root节点
     */
    private TreeNode insert(TreeNode root, int val, Map<TreeNode,Integer> nodeHeight){
        if (root == null){
            root = new TreeNode(val);
            nodeHeight.put(root,1);// 新节点的高度
            return root;
        }
        TreeNode node = root;
        int parentVal = node.val;
        if (parentVal > val) { // 插入值小于当前节点，插入左子树
            // 左子树插入
            node.left = insert(root.left,val,nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            // 这里因为是插入的左子树节点，所以判断左边插入后高度是否高于右子树+1(平衡二叉树左右子树高度差不能超过1)
            if (nodeHeight.getOrDefault(node.left,0) - nodeHeight.getOrDefault(node.right,0) > 1) {
                if (val > node.left.val){
                    // 插入在左孩子右边，左孩子先左旋
                    node.left = rotateLeft(node.left,nodeHeight);
                }
                // 节点右旋
                node = rotateRight(node,nodeHeight);
            }
        } else if (parentVal < val) { // 插入值大于当前节点，插入右子树
            // 右子树插入
            node.right = insert(root.right,val,nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整;
            // 这里因为是插入的右子树节点，所以判断右边插入后高度是否高于左子树+1(平衡二叉树左右子树高度差不能超过1)
            if (nodeHeight.getOrDefault(node.right,0) - nodeHeight.getOrDefault(node.left,0) > 1){
                if (val < node.right.val){
                    // 插入在右孩子左边，右孩子先右旋
                    node.right = rotateRight(node.right,nodeHeight);
                }
                // 节点左旋
                node = rotateLeft(node,nodeHeight);
            }
        } else {
            // 一样的节点，啥都没发生
            return node;
        }
        // 获取当前节点新高度
        int height =  getCurNodeNewHeight(node,nodeHeight);
        // 更新当前节点高度
        nodeHeight.put(node,height);
        return node;
    }

    /**
     * node节点左旋
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateLeft(TreeNode node, Map<TreeNode,Integer> nodeHeight){
        // ---指针调整
        TreeNode right = node.right;
        node.right = right.left;
        right.left = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node,nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node,newNodeHeight);
        // newNodeHeight是现在right节点左子树高度，原理一样，取现在right左右子树最大高度+1
        int newRightHeight = Math.max(newNodeHeight,nodeHeight.getOrDefault(right.right,0)) + 1;
        // 更新原right节点高度
        nodeHeight.put(right,newRightHeight);
        return right;
    }

    /**
     * node节点右旋
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateRight(TreeNode node,Map<TreeNode,Integer> nodeHeight){
        // ---指针调整
        TreeNode left = node.left;
        node.left = left.right;
        left.right = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node,nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node,newNodeHeight);
        // newNodeHeight是现在left节点右子树高度，原理一样，取现在right左右子树最大高度+1
        int newLeftHeight = Math.max(newNodeHeight,nodeHeight.getOrDefault(left.left,0)) + 1;
        // 更新原left节点高度
        nodeHeight.put(left,newLeftHeight);
        return left;
    }

    /**
     * 获取当前节点的新高度
     * @param node node
     * @param nodeHeight node高度缓存
     * @return 当前node的新高度
     */
    private int getCurNodeNewHeight(TreeNode node,Map<TreeNode,Integer> nodeHeight){
        // node节点的高度，为现在node左右子树最大高度+1
        return Math.max(nodeHeight.getOrDefault(node.left,0),nodeHeight.getOrDefault(node.right,0)) + 1;
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

