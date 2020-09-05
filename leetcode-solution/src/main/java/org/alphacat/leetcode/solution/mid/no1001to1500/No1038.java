package org.alphacat.leetcode.solution.mid.no1001to1500;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No1038 {
    private int preSum = 0;
    public TreeNode bstToGst(TreeNode root) {
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
