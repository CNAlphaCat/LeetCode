package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.ListNode;

public class No92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode begin = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            begin = begin.next;
        }

        ListNode p = begin.next;
        ListNode tail = p;

        begin.next = null;

        for (int i = 0; i < n - m + 1; ++i) {
            ListNode next = p.next;
            p.next = begin.next;
            begin.next = p;
            p = next;
        }

        tail.next = p;
        return dummyHead.next;
    }
}
