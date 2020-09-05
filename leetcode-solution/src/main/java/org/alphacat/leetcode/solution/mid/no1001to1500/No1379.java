package org.alphacat.leetcode.solution.mid.no1001to1500;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return preOrder(original, cloned, target);
    }

    private TreeNode preOrder(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode leftNode = preOrder(original.left, cloned.left, target);
        if (leftNode != null) {
            return leftNode;
        }
        TreeNode rightNode = preOrder(original.right, cloned.right, target);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }
}
