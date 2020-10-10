package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.ListNode;

public class No142 {

    private final static ListNode NO_CYCLE_NODE = null;

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = oneStep(slow);
            fast = twoStep(fast);

            if (fast == null) {
                return NO_CYCLE_NODE;
            }

            if (slow == fast) {
                break;
            }
        }

        ListNode p = head;
        while (p != fast) {
            p = p.next;
            fast = fast.next;
        }
        return p;
    }

    private ListNode oneStep(ListNode node) {
        return node == null ? null : node.next;
    }

    private ListNode twoStep(ListNode node) {
        ListNode temp = oneStep(node);
        return oneStep(temp);
    }
}
