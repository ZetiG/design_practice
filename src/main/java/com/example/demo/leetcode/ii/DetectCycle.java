package com.example.demo.leetcode.ii;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * @author Zeti
 * @date 2024/4/3 17:37
 */
public class DetectCycle {
    public static void main(String[] args) {
        // head = [3,2,0,-4], pos = 1

        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;
        System.err.println(detectCycle(l3).val);

        ListNode l_1 = new ListNode(1);
        ListNode l_2 = new ListNode(2);
        l_1.next = l_2;
        l_2.next = l_1;
        System.err.println(detectCycle(l_1).val);

    }

    // 核心点：
    // 1.快慢指针，成环的链表二者终会相遇
    // 2.当二者相遇后，将快指针重置为链表头节点，然后和慢指针同时以相同的速度移动，二者终会在环的入口相遇
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 快慢指针相遇，代表成环，这时快指针重置且和慢指针同时以「同样的步长1」移动，
            // 二者最终会在「环」的「入口」相遇
            if (fast == slow) {
                fast = head;

                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    // 哈希表存储所有节点，每次遍历一个节点时，判断该节点的下个节点是否已经在哈希表内，存在则成环
    public static ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            set.add(curr);

            curr = curr.next;
            if (curr != null && set.contains(curr.next)) {
                return curr.next;
            }
        }
        return null;
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

