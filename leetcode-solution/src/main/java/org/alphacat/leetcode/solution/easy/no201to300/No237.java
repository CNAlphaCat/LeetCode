package org.alphacat.leetcode.solution.easy.no201to300;


import org.alphacat.leetcode.datastructure.ListNode;

public class No237 {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
