package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160. 相交链表
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 编写一个程序，找到两个单链表相交的起始节点。
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No160_getIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

	public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
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
}
