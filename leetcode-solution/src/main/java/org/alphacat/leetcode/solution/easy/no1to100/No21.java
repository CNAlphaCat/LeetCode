package org.alphacat.leetcode.solution.easy.no1to100;


import org.alphacat.leetcode.datastructure.ListNode;

public class No21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preRes = new ListNode(-1);
        ListNode p = preRes;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
        }
        return preRes.next;
    }
}
