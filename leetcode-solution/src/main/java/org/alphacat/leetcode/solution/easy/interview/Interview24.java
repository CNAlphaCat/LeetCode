package org.alphacat.leetcode.solution.easy.interview;


import org.alphacat.leetcode.datastructure.ListNode;

public class Interview24 {
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
