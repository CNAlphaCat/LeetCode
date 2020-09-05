package org.alphacat.leetcode.solution.easy.no501to600;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No538 {

    private int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.right);
        int val = node.val;
        node.val += preSum;
        preSum += val;
        postOrder(node.left);
    }
}
