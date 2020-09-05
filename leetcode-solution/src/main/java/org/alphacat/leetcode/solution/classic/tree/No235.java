package org.alphacat.leetcode.solution.classic.tree;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int pValue = p.val;
        int qValue = q.val;
        int nodeValue = root.val;
        if (nodeValue > pValue && nodeValue > qValue) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (nodeValue < pValue && nodeValue < qValue) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int q_val = q.val, p_val = p.val;
        if (p_val > q_val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (root == p) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right == q) {
                return root;
            }
            return root;
        }
        if (root == q) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left == p) {
                return root;
            }
            return root;
        }
        int node_val = root.val;
        if (node_val < p_val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (node_val > q_val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == p && right == q) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
