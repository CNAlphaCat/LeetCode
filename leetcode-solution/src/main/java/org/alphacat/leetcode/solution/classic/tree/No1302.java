package org.alphacat.leetcode.solution.classic.tree;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No1302 {
    private int sum;
    private int maxDepth;

    public int deepestLeavesSum(TreeNode root) {
        initial();
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (h > maxDepth) {
                maxDepth = h;
                sum = root.val;
            } else if (h == maxDepth) {
                sum += root.val;
            }
            return;
        }
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }

    private void initial() {
        this.sum = 0;
        this.maxDepth = 0;
    }
}
