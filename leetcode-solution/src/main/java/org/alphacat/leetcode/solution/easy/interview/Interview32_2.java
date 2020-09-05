package org.alphacat.leetcode.solution.easy.interview;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interview32_2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new LinkedList<List<Integer>>();
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> resList = new LinkedList<List<Integer>>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> temp = new LinkedList<Integer>();
			int n = q.size();
			for (int i = 0; i < n; ++i) {
				TreeNode tempNode = q.poll();
				temp.add(tempNode.val);
				if (tempNode.left != null) {
					q.add(tempNode.left);
				}
				if (tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
			resList.add(temp);
		}
		return resList;
	}
}
