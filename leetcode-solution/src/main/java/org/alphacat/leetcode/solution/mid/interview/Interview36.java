package org.alphacat.leetcode.solution.mid.interview;

public class Interview36 {
	private Node res;
	private Node preNode;

	public Node treeToDoublyList(Node root) {
		initial();
		inOrder(root);
		return this.res;
	}

	private void initial() {
		this.res = null;
		this.preNode = null;
	}

	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		int val = root.val;
		Node crrNode = new Node(val);
		if (this.res == null) {
			this.res = crrNode;
			this.preNode = crrNode;
			crrNode.left = crrNode;
			crrNode.right = crrNode;
		} else {
			crrNode.left = this.preNode;
			crrNode.right = this.preNode.right;
			this.preNode.right = crrNode;
			this.res.left = crrNode;
			this.preNode = crrNode;
		}
		inOrder(root.right);
	}

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
}
