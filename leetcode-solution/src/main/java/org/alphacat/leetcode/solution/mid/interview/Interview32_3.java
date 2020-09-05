package org.alphacat.leetcode.solution.mid.interview;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Interview32_3 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new LinkedList<List<Integer>>();
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		q.add(root);
		List<List<Integer>> resList = new LinkedList<List<Integer>>();
		int depth = 1;
		while (!q.isEmpty()) {
			int n = q.size();
			List<Integer> tempList = new LinkedList<Integer>();
			for (int i = 0; i < n; ++i) {
				TreeNode tempNode = q.poll();
				if (depth % 2 == 0) {
					s.add(tempNode);
				} else {
					tempList.add(tempNode.val);
				}
				if (tempNode.left != null) {
					q.add(tempNode.left);
				}
				if (tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
			while (depth % 2 == 0 && !s.isEmpty()) {
				TreeNode tempNode = s.pop();
				tempList.add(tempNode.val);
			}
			resList.add(tempList);
			depth++;
		}
		return resList;
	}
}
