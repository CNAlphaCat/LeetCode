package org.alphacat.leetcode.solution.easy.no101to200;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No108 {
	private int[] nums;
	private int length;

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		initial(nums);
		int mid = this.length / 2;
		int val = nums[mid];
		TreeNode root = new TreeNode(val);
		root.left = buildTree(0, mid - 1);
		root.right = buildTree(mid + 1, length - 1);
		return root;
	}

	private TreeNode buildTree(int begin, int end) {
		if (begin > end) {
			return null;
		}
		if (begin < 0) {
			return null;
		}
		if (end >= this.length) {
			return null;
		}
		int mid = (end + begin) / 2;
		int val = nums[mid];
		TreeNode root = new TreeNode(val);
		root.left = buildTree(begin, mid - 1);
		root.right = buildTree(mid + 1, end);
		return root;
	}

	private void initial(int[] n) {
		this.nums = n;
		this.length = n.length;
	}
}
