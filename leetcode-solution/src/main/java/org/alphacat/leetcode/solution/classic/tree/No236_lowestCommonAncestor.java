package org.alphacat.leetcode.solution.classic.tree;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No236_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == p && right == q) {
            return root;
        }
        if (left == q && right == p) {
            return root;
        }

        // 错误写法：if (left == p || left == q)
        // 如果下面返回的是非p非q的公共节点，这里就会截获

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
