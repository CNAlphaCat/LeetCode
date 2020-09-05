package org.alphacat.leetcode.solution.mid.no1to1000;


import org.alphacat.leetcode.datastructure.ListNode;

public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current != null) {
            exchange(current);
            current = getNext(current);
        }
        return dummyHead.next;
    }

    private ListNode getNext(ListNode node) {
        ListNode temp = node;
        if (temp.next != null) {
            temp = temp.next;
        } else {
            return null;
        }
        if (temp.next != null) {
            temp = temp.next;
        } else {
            return null;
        }
        return temp;
    }

    private void exchange(ListNode node) {
        ListNode first = node.next;
        ListNode second = null;
        if (first != null) {
            second = first.next;
        }
        if (first != null && second != null) {
            ListNode post = second.next;
            node.next = second;
            second.next = first;
            first.next = post;
        }
    }
}
