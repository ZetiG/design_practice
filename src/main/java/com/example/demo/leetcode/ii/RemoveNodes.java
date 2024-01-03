package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;

/**
 * Description: 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * 移除每个右侧有一个更大数值的节点。
 * 返回修改后链表的头节点 head 。
 *
 * @author Zeti
 * @date 2024/1/3 11:28
 */
public class RemoveNodes {
    public static void main(String[] args) {
        // [5,2,13,3,8]
        ListNode n5 = new ListNode(8);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(13, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(5, n2);
        System.err.println(removeNodes(n1));

    }


    public static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            deque.addFirst(node);
            node = node.next;
        }

        ListNode lastNode = deque.peek();
        for (ListNode listNode : deque) {
            if (lastNode == listNode) {
                continue;
            }
            if (listNode.val >= lastNode.val) {
                listNode.next = lastNode;
                lastNode = listNode;
            }
        }
        return lastNode;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

