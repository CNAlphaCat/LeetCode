package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.ListNode;

public class No328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = head;

        ListNode odd = new ListNode(0);
        ListNode p1 = odd;

        ListNode even = new ListNode(0);
        ListNode p2 = even;

        while (p != null) {
            p1.next = p;
            p1 = p1.next;

            p = p.next;
            p1.next = null;
            if (p == null) {
                break;
            }

            p2.next = p;
            p2 = p2.next;

            p = p.next;
            p2.next = null;
        }

        dummyHead.next = odd.next;
        p1.next = even.next;
        return dummyHead.next;
    }

}
