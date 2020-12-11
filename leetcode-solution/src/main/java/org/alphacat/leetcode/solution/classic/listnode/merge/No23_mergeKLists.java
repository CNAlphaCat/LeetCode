package org.alphacat.leetcode.solution.classic.listnode.merge;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 23. 合并K个升序链表
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No23_mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        return mergeKLists(lists, 0, n - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        int mid = low + ((high - low) >> 1);
        ListNode l1 = mergeKLists(lists, low, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, high);
        return mergeListNode(l1, l2);
    }

    public ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode newNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            current.next = newNode;
            current = newNode;
        }
        current.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
