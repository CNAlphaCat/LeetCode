package org.alphacat.leetcode.solution.easy.no201to300;

import org.alphacat.leetcode.datastructure.ListNode;

public class No206 {

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
}
