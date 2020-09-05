package org.alphacat.leetcode.solution.mid.interview;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview32_1 {

	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> intQ = new LinkedList<Integer>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tempNode = q.poll();
			intQ.add(tempNode.val);
			if (tempNode.left != null) {
				q.add(tempNode.left);
			}
			if (tempNode.right != null) {
				q.add(tempNode.right);
			}
		}
		int[] res = getIntArr(intQ);
		return res;
	}

	private int[] getIntArr(Queue<Integer> intQ) {
		int n = intQ.size();
		int[] res = new int[n];
		for (int i = 0; i < n; ++i) {
			res[i] = intQ.poll();
		}
		return res;
	}
}
