package org.alphacat.leetcode.solution.easy.no801to900;


import org.alphacat.leetcode.datastructure.ListNode;

public class No876 {

    public ListNode middleNode(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fastPoint = dummyHead;
        ListNode slowPoint = dummyHead;
        while (true) {
            slowPoint = getNextSlowPoint(slowPoint);
            fastPoint = getFastPointPostNode(fastPoint);
            if (fastPoint == null) {
                return slowPoint;
            }
        }
    }

    private ListNode getNextSlowPoint(ListNode slowPoint) {
        if (slowPoint == null) {
            return null;
        }
        return slowPoint.next == null ? null : slowPoint.next;
    }

    private ListNode getFastPointPostNode(ListNode fastPoint) {
        if (fastPoint == null) {
            return null;
        }
        ListNode postNode = fastPoint.next;
        if (postNode == null) {
            return null;
        }
        return postNode.next != null ? postNode.next : null;
    }
}
