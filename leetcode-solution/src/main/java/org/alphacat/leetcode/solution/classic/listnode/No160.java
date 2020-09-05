package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.HashSet;

public class No160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}

	// ˫ָ�뷨
	public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
