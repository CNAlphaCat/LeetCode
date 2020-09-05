package org.alphacat.leetcode.solution.easy.interview;


import org.alphacat.leetcode.datastructure.ListNode;

public class Interview02_03 {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        int val = nextNode.val;
        node.val = val;
        node.next = nextNode.next;
    }
}
