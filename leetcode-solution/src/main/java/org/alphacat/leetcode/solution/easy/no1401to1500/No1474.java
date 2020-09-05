package org.alphacat.leetcode.solution.easy.no1401to1500;


import org.alphacat.leetcode.datastructure.ListNode;

public class No1474 {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        while (pointer != null) {
            pointer = getPost(pointer, m);
            if (pointer == null) {
                break;
            }
            ListNode postNode = getPost(pointer, n + 1);
            pointer.next = postNode;
        }
        return head;
    }

    private ListNode getPost(ListNode node, int count) {
        for (int i = 0; i < count && node != null; i++) {
            node = node.next;
        }
        return node;
    }
}
