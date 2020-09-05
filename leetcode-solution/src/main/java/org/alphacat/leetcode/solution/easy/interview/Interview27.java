package org.alphacat.leetcode.solution.easy.interview;


import org.alphacat.leetcode.datastructure.TreeNode;

public class Interview27 {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = mirrorTree(root.left);
		TreeNode right = mirrorTree(root.right);
		TreeNode tempNode = left;
		root.left = right;
		root.right = tempNode;
		return root;
	}
}
