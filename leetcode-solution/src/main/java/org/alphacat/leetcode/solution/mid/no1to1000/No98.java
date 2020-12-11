package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class No98 {

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, null, null);
    }

    private boolean inOrder(TreeNode node, Integer lower, Integer higher) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (higher != null && val >= higher) {
            return false;
        }

        if (!inOrder(node.left, lower, val)) {
            return false;
        }
        if (!inOrder(node.right, val, higher)) {
            return false;
        }
        return true;
    }
}
