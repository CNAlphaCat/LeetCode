package org.alphacat.leetcode.solution.easy.no601to700;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < L) {
            return trimBST(root.right, L, R);
        }
        if (val > R) {
            return trimBST(root.left, L, R);
        }
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        root.left = left;
        root.right = right;
        return root;
    }
}
