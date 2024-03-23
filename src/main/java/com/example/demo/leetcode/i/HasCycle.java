package com.example.demo.leetcode.i;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递
 * 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * @author Zeti
 * @date 2024/3/23 15:03
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.err.println(hasCycle(l1));   // true

    }

    // 快慢指针，有环的情况下，两个指针一定会相遇，无环就直接结束循环了
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    // 集合存储遍历过的节点，每次插入判断是否已经存在，存在代表有环
    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        List<ListNode> nodeMap = new ArrayList<>();
        ListNode lastNode = head;
        while (lastNode != null) {
            if (nodeMap.contains(lastNode)) {
                return true;
            }
            nodeMap.add(lastNode);
            lastNode = lastNode.next;
        }
        return false;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

}
