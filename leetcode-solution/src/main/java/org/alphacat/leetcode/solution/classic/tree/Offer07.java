package org.alphacat.leetcode.solution.classic.tree;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.HashMap;

public class Offer07 {
	private HashMap<Integer, Integer> map;
	private int n;
	private int[] pre;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		n = inorder.length;
		map = getMap(inorder);
		pre = preorder;
		TreeNode res = buildTree(0, 0, n - 1);
		return res;
	}

	private TreeNode buildTree(int b1, int b2, int e2) {
		if (b2 > e2) {
			return null;
		}
		int val = pre[b1];
		TreeNode res = new TreeNode(val);
		int index = map.get(val);
		res.left = buildTree(b1 + 1, b2, index - 1);
		res.right = buildTree(b1 + index - b2 + 1, index + 1, e2);
		return res;
	}

	private HashMap<Integer, Integer> getMap(int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			map.put(inorder[i], i);
		}
		return map;
	}
}
