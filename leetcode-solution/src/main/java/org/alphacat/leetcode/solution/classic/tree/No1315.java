package org.alphacat.leetcode.solution.classic.tree;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No1315 {


    private class dataHelper {
        TreeNode root;
        boolean isSon;
        boolean isGrandSon;

        public dataHelper(TreeNode _root, boolean _isSon, boolean _isGrandSon) {
            this.root = _root;
            this.isGrandSon = _isGrandSon;
            this.isSon = _isSon;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<dataHelper> queue = new LinkedList<>();
        dataHelper dp = new dataHelper(root, false, false);
        queue.add(dp);
        int sum = 0;
        while (!queue.isEmpty()) {
            dataHelper tempDH = queue.poll();
            TreeNode node = tempDH.root;
            boolean isSon = isEven(node.val);
            boolean isGrandSon = tempDH.isSon;
            if (tempDH.isGrandSon) {
                sum += node.val;
            }
            if (node.left != null) {
                tempDH = new dataHelper(node.left, isSon, isGrandSon);
                queue.add(tempDH);
            }
            if (node.right != null) {
                tempDH = new dataHelper(node.right, isSon, isGrandSon);
                queue.add(tempDH);
            }
        }
        return sum;
    }

    private boolean isEven(int num) {
        return (num & 1) != 1;
    }

    public int sumEvenGrandparent_dfs(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode root, TreeNode parentNode, TreeNode grandParentNode) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (grandParentNode != null && isEven(grandParentNode.val)) {
            val = root.val;
        }
        return dfs(root.left, root, parentNode) + dfs(root.right, root, parentNode) + val;
    }
}
