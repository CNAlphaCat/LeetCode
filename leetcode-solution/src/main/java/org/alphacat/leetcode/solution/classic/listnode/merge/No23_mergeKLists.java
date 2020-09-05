package org.alphacat.leetcode.solution.classic.listnode.merge;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class No23_mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            ListNode currentNode = new ListNode(val);
            current.next = currentNode;
            current = currentNode;
        }
        return head.next;
    }

    public ListNode mergeKLists_2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        return mergeKLists(lists, 0, n);
    }

    private ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high - 1) {
            return lists[low];
        }
        int mid = low + ((high - low) >> 1);
        ListNode l1 = mergeKLists(lists, low, mid);
        ListNode l2 = mergeKLists(lists, mid, high);
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
