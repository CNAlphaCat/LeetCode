package org.alphacat.leetcode.solution.classic.tree.bst;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No450_deleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        int val = root.val;
        if (val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left != null) {
            int pre = findPre(root);
            root.val = pre;
            root.left = deleteNode(root.left, pre);
        } else {
            int post = findPost(root);
            root.val = post;
            root.right = deleteNode(root.right, post);
        }
        return root;
    }

    private int findPre(TreeNode node) {
        TreeNode cur = node.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.val;
    }

    private int findPost(TreeNode node) {
        TreeNode cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }
}
