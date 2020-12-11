package org.alphacat.leetcode.solution.easy.no201to300;

import org.alphacat.leetcode.datastructure.ListNode;

public class No206_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode crrNode = head;
        ListNode preNode = null;
        while (crrNode != null) {
            ListNode nextNode = crrNode.next;
            crrNode.next = preNode;
            preNode = crrNode;
            crrNode = nextNode;
        }
        return preNode;
    }

    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode p = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return p;
    }
}
