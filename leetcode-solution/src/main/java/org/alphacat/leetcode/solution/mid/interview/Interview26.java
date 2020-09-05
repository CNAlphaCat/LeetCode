package org.alphacat.leetcode.solution.mid.interview;


import org.alphacat.leetcode.datastructure.TreeNode;

public class Interview26 {

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (!(A != null && B != null)) {
			return false;
		}
		if (isSub(A, B)) {
			return true;
		}
		if (isSubStructure(A.left, B)) {
			return true;
		}
		if (isSubStructure(A.right, B)) {
			return true;
		}
		return false;
	}
	
	private boolean isSub(TreeNode A, TreeNode Bcrr) {
		if (Bcrr == null) {
			return true;
		}
		if (A == null || A.val != Bcrr.val) {
			return false;
		}
		return isSub(A.left, Bcrr.left) && isSub(A.right, Bcrr.right);
	}

}
