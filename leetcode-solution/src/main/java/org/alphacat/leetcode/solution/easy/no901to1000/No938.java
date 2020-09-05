package org.alphacat.leetcode.solution.easy.no901to1000;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No938 {

    private int L;
    private int R;
    private int sum;
    private boolean isCount;
    private boolean isFinish;

    public int rangeSumBST(TreeNode root, int L, int R) {
        initial(L, R);
        inOrder(root);
        return this.sum;
    }

    private void inOrder(TreeNode node) {
        if (node == null || isFinish) {
            return;
        }
        inOrder(node.left);
        int val = node.val;
        if (val == L) {
            this.isCount = true;
        }
        if (val == R) {
            sum += val;
            this.isCount = false;
            this.isFinish = true;
            return;
        }
        if (this.isCount) {
            sum += val;
        }
        inOrder(node.right);
    }

    private void initial(int _L, int _R) {
        this.L = _L;
        this.R = _R;
        this.sum = 0;
        this.isCount = false;
        this.isFinish = false;
    }
}
