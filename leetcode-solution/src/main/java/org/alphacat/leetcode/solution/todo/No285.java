package org.alphacat.leetcode.solution.todo;

import org.alphacat.leetcode.datastructure.TreeNode;

public class No285 {

    private TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p, false);
        return res;
    }

    private void inorder(TreeNode node, TreeNode p, boolean isP) {
        if (node == null) {
            return;
        }
        inorder(node.left, p, false);
        if (isP) {
            res = node;
        }
        if (node == p) {
            inorder(node.right, p, true);
        } else {
            inorder(node.right, p, false);
        }
    }
}
