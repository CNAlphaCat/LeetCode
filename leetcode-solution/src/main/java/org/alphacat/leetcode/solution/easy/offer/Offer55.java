package org.alphacat.leetcode.solution.easy.offer;


import org.alphacat.leetcode.datastructure.TreeNode;

public class Offer55 {

    private boolean ans = true;
    private int UNBALANCE_NUM = -1;

    public boolean isBalanced(TreeNode root) {
        preOrder(root);
        return ans;
    }

    private int preOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (!ans) {
            return UNBALANCE_NUM;
        }

        int left = preOrder(node.left) + 1;
        int right = preOrder(node.right) + 1;

        if (Math.abs(left - right) > 1) {
            ans = false;
            return UNBALANCE_NUM;
        }

        return Math.max(left, right);
    }
}
