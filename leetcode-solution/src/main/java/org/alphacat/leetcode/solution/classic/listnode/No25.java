package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

public class No25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode crrNode = temp;
		ListNode preNode = temp;
		while (true) {
			for (int i = 0; i < k && crrNode != null; ++i) {
				crrNode = crrNode.next;
			}
			if (crrNode == null) {
				break;
			}
			ListNode begin = preNode.next;
			ListNode next = crrNode.next;
			preNode.next = reverse(begin, crrNode);
			begin.next = next;
			preNode = begin;
			crrNode = begin;
		}
		return temp.next;
	}

	private ListNode reverse(ListNode begin, ListNode end) {
		end.next = null;
		ListNode preNode = null;
		ListNode crrNode = begin;
		while (crrNode != null) {
			ListNode nextNode = crrNode.next;
			crrNode.next = preNode;
			preNode = crrNode;
			crrNode = nextNode;
		}
		return preNode;// �������ú��β�����
	}
}
