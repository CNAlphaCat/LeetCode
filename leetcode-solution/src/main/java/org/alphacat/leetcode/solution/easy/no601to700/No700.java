package org.alphacat.leetcode.solution.easy.no601to700;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        int nodeVal = root.val;
        if (nodeVal == val) {
            return root;
        } else if (nodeVal > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public TreeNode searchBST_2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return checkNode(left, right);
    }

    private TreeNode checkNode(TreeNode left, TreeNode right) {
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
