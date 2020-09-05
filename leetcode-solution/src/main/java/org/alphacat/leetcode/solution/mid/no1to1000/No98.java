package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class No98 {

    private int preNum;
    private LinkedList isFindFirstNum;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!inOrder(node.left)) {
            return false;
        }
        if (isFindFirstNum == null) {
            isFindFirstNum = new LinkedList();
            preNum = node.val;
        } else if (node.val <= preNum) {
            return false;
        }
        preNum = node.val;
        return inOrder(node.right);
    }
}
