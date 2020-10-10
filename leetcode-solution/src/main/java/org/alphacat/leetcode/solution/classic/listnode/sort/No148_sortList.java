package org.alphacat.leetcode.solution.classic.listnode.sort;

import org.alphacat.leetcode.datastructure.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 * ☆☆☆☆
 * keyword:归并排序，链表
 * 题解：https://leetcode-cn.com/problems/sort-list/solution/gui-bing-pai-xu-die-dai-fa-bottom-up-by-da-wei-wan/
 */
public class No148_sortList {

    class NodeSet {
        public ListNode head;
        public ListNode tail;

        public NodeSet(ListNode _head, ListNode _tail) {
            head = _head;
            tail = _tail;
        }
    }

    public ListNode sortList(ListNode head) {
        int n = getLen(head);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (int step = 1; step <= n; step <<= 1) {
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);

                NodeSet nodeSet = merge(left, right);
                pre.next = nodeSet.head;
                pre = nodeSet.tail;
            }
        }

        return dummyHead.next;
    }

    private ListNode split(ListNode node, int step) {
        if (node == null) {
            return null;
        }
        for (int i = 1; i < step && node.next != null; ++i) {
            node = node.next;
        }
        ListNode ans = node.next;
        node.next = null;
        return ans;
    }

    private NodeSet merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        while (p.next != null) {
            p = p.next;
        }
        return new NodeSet(dummyHead.next, p);
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
}
