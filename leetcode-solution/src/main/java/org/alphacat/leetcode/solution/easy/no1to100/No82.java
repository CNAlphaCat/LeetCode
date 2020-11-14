package org.alphacat.leetcode.solution.easy.no1to100;

import org.alphacat.leetcode.datastructure.ListNode;

public class No82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (!isUnique(cur)) {
                ListNode nextNode = findNext(cur);
                pre.next = nextNode;
                cur = nextNode;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode findNext(ListNode node) {
        int val = node.val;
        ListNode nextNode = node.next;
        while (nextNode != null && nextNode.val == val) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    private boolean isUnique(ListNode node) {
        if (node == null) {
            return true;
        }
        ListNode nextNode = node.next;
        if (nextNode == null) {
            return true;
        }
        return node.val != nextNode.val;
    }
}
