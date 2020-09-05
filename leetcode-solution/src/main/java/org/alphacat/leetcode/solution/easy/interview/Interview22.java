package org.alphacat.leetcode.solution.easy.interview;

import org.alphacat.leetcode.datastructure.ListNode;

public class Interview22 {
	

	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode preListNode=head;
		ListNode posListNode=head;
		for(int i=0;i<k;i++) {
			preListNode=preListNode.next;
		}
		while(preListNode!=null) {
			preListNode=preListNode.next;
			posListNode=posListNode.next;
		}
		return posListNode;
	}
}
