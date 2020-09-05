package org.alphacat.leetcode.solution.hard;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        order(root);
        return max;
    }

    private int order(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = order(node.left);

        int right = order(node.right);

        int sum = Math.max(left, right) + node.val;

        max = Math.max(sum, max);
        max = Math.max(left + right + node.val, max);

        return sum < 0 ? 0 : sum;
    }
}
