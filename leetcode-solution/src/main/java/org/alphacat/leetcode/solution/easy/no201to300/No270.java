package org.alphacat.leetcode.solution.easy.no201to300;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No270 {
	public int closestValue(TreeNode root, double target) {
		int thisNum = root.val;
		if (root.left == null && root.right == null) {
			return root.val;
		} else if (root.left == null && root.right != null) {
			int right = closestValue(root.right, target);
			return getMin(right, thisNum, target);
		} else if (root.left != null && root.right == null) {
			int left = closestValue(root.left, target);
			return getMin(left, thisNum, target);
		} else {
			int left = closestValue(root.left, target);
			int right = closestValue(root.right, target);
			return getMin(left, right, thisNum, target);
		}
	}

	int getMin(int left, int thisNum, double target) {
		double thisDiff = Math.abs(thisNum - target);
		double leftDiff = Math.abs(left - target);
		if (thisDiff > leftDiff) {
			return left;
		}
		return thisNum;
	}

	int getMin(int left, int right, int thisNum, double target) {
		double thisDiff = Math.abs(thisNum - target);
		double rightDiff = Math.abs(right - target);
		double leftDiff = Math.abs(left - target);
		double min = Math.min(thisDiff, rightDiff);
		min = Math.min(min, leftDiff);
		if (min == thisDiff) {
			return thisNum;
		}
		if (min == rightDiff) {
			return right;
		}
		return left;
	}
}
