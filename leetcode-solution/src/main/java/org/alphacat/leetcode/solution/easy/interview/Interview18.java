package org.alphacat.leetcode.solution.easy.interview;


import org.alphacat.leetcode.datastructure.ListNode;

public class Interview18 {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode temp = head;
		ListNode pre = null;
		while (temp != null && temp.val != val) {
			pre = temp;
			temp = temp.next;
		}
		if (temp == null)
			return head;
		if (temp == head) {
			return temp.next;
		}
		pre.next = temp.next;
		return head;
	}
}
