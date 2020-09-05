package org.alphacat.leetcode.solution.easy.no101to200;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No104 {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
