package org.alphacat.leetcode.solution.easy.no601to700;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t2 == null) {
            TreeNode res = new TreeNode(t1.val);
            res.left = mergeTrees(t1.left, null);
            res.right = mergeTrees(t1.right, null);
            return res;
        }
        if (t1 == null) {
            TreeNode res = new TreeNode(t2.val);
            res.left = mergeTrees(null, t2.left);
            res.right = mergeTrees(null, t2.right);
            return res;
        }
        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);
        return res;
    }

}
