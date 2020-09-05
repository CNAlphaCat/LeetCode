package org.alphacat.leetcode.solution.easy.interview;



import org.alphacat.leetcode.datastructure.ListNode;

import java.util.Stack;

public class Interview06 {

	public int[] reversePrint(ListNode head) {
		Stack<Integer> s = new Stack<Integer>();
		while (head != null) {
			s.push(head.val);
			head = head.next;
		}
		int size = s.size();
		int[] res = new int[size];
		int temp = 0;
		for (int i = 0; i < size; i++) {
			temp = s.pop();
			res[i] = temp;
		}
		return res;
	}
}
