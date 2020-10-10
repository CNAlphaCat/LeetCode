package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.ListNode;

public class No61 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        int len = 0;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            ++len;
        }

        if (len < k) {
            k %= len;
            fast = dummyHead;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
        }

        ListNode slow = dummyHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        ListNode p = slow;

        while (p != null) {
            cur.next = p;
            cur = cur.next;
            p = p.next;
        }

        p = head;

        while (p != slow) {
            cur.next = p;
            cur = cur.next;
            p = p.next;
        }
        cur.next = null;

        return ans.next;
    }
}
