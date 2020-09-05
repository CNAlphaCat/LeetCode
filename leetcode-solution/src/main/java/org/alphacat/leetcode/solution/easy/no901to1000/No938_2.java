package org.alphacat.leetcode.solution.easy.no901to1000;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No938_2 {
    private int L;
    private int R;

    public int rangeSumBST(TreeNode root, int L, int R) {
        initial(L, R);
        return inOrder(root);
    }

    private int inOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val;
        if (val > R) {
            return inOrder(node.left);
        }
        if (val < L) {
            return inOrder(node.right);
        }
        return node.val + inOrder(node.left) + inOrder(node.right);
    }

    private void initial(int _L, int _R) {
        this.L = _L;
        this.R = _R;
    }
}
