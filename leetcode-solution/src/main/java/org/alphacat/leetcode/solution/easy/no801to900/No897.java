package org.alphacat.leetcode.solution.easy.no801to900;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No897 {

    private TreeNode headNode;
    private TreeNode crrNode;

    public TreeNode increasingBST(TreeNode root) {
        initial();
        inorder(root);
        return headNode;
    }

    private void initial() {
        headNode = null;
        crrNode = null;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        int val = root.val;
        if (headNode == null) {
            headNode = new TreeNode(val);
            crrNode = headNode;
        } else {
            crrNode.right = new TreeNode(val);
            crrNode = crrNode.right;
        }
        inorder(root.right);
    }
}
