package org.alphacat.leetcode.solution.mid.interview;

import java.util.HashMap;


public class Interview35 {
	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node resNode = new Node(head.val);
		Node preNode = resNode;
		Node headNode = head;
		Node crrNode;
		headNode = headNode.next;
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		map.put(head, resNode);
		while (headNode != null) {
			int val = headNode.val;
			crrNode = new Node(val);
			map.put(headNode, crrNode);
			preNode.next = crrNode;
			headNode = headNode.next;
			preNode = crrNode;
		}
		headNode = head;
		crrNode = resNode;
		while (headNode != null) {
			Node randomNode = map.get(headNode.random);
			crrNode.random = randomNode;
			crrNode = crrNode.next;
			headNode = headNode.next;
		}
		return resNode;
	}
}
