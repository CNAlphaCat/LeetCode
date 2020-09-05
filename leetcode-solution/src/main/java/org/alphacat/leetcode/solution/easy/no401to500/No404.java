package org.alphacat.leetcode.solution.easy.no401to500;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        int left = sumOfLeftLeaves(node.left, true);
        int right = sumOfLeftLeaves(node.right, false);
        return left + right;
    }
}
