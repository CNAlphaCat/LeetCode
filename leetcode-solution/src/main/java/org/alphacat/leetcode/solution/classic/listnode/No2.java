package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode crr = l;
        int x = 0, y = 0, sum = 0, n = 0, j = 0;
        while (l1 != null || l2 != null || j != 0) {
            x = (l1 != null) ? l1.val : 0;
            y = (l2 != null) ? l2.val : 0;
            sum = x + y + j;
            n = sum % 10;
            j = sum / 10;
            crr.next = new ListNode(n);
            crr = crr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return l.next;
    }
}
