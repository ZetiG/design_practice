package com.example.demo.data_structure;

import lombok.NonNull;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/3/14 10:36 AM
 */
public class DemoList {
    final int maxLevel = 16;
    Node headNode;
//    int currentLevel = 1;

    public DemoList(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {

        // [30, 40, 50, 60, 70, 90] ，然后增加 80、45
        DemoList dl = new DemoList(new Node(null, null, null));

        int[] arr = new int[]{30, 40, 50, 60, 70, 90};
        for (int i = 0; i < arr.length; i++) {
            dl.add(arr[i]);
        }

        dl.add(80);
        dl.add(45);

        System.err.println(" ");
        System.err.println("-------------------");
        System.err.println(" ");


        dl.erase(30);

    }

    public boolean search(int target) {
        return searchTarget(target) != null;
    }

    public Node searchTarget(int target) {
        Node hd = this.headNode;

        while (hd != null) {
            if (hd.val != null && hd.val == target) {
                return hd;
            }

            if (hd.right != null && hd.right.val < target) {
                hd = hd.right;
            } else {
                hd = hd.down;
            }
        }
        return null;
    }

    //  1       5
    //  1   3   5   7
    //  1 2 3 4 5 6 7 8
    public void add(int num) {
        // 已存在跳表内，直接替换val
        Node node = searchTarget(num);
        if (node != null) {
            while (node != null) {
                node.val = num;
                node = node.down;
            }
            return;
        }

        // 创建当前待插入节点
        Node hd = this.headNode;
        if (hd == null || hd.val == null) {
            this.headNode = new Node(num, null, null);
            return;
        }

        Stack<Node> stk = new Stack<>();
        while (hd != null) {
            if (hd.val == num || hd.right == null || hd.right.val > num) {
                stk.push(hd);
                hd = hd.down;
            } else {
                hd = hd.right;
            }
        }

        int level = 1;

        Node lastDown = null;
        while (!stk.empty()) {

            Node pop = stk.pop();
            Node newNd = new Node(num, pop.right, lastDown);
            pop.right = newNd;
            lastDown = newNd;

            if (level > maxLevel || !(RandomUtils.nextFloat(0, 1) > 0.5)) {
                return;
            }

            level++;

            Node levelHeadNode = new Node(this.headNode.val, null, null);
            levelHeadNode.down = this.headNode;
            this.headNode = levelHeadNode;
            stk.push(this.headNode);
        }
    }


    public boolean erase(int num) {
//        Node hd = this.headNode;
//
//        ArrayDeque<Node> deque = new ArrayDeque<>();
//
//        while (hd != null) {
//            if (hd.val != null && hd.val == num) {
//                deque.push(hd);
//
//                if (hd.down == null) {
//
//                }
//            }
//
//            if (hd.right != null && hd.right.val < num) {
//                hd = hd.right;
//            } else {
//                hd = hd.down;
//            }
//
//        }
//
        return true;
    }



    static class Node {
        Integer val;
        Node right, down;

        public Node(Integer val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }


}
