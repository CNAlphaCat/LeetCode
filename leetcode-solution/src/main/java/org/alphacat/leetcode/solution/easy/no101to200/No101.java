package org.alphacat.leetcode.solution.easy.no101to200;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        return isSym(leftNode.left, rightNode.right) && isSym(leftNode.right, rightNode.left);
    }
}
