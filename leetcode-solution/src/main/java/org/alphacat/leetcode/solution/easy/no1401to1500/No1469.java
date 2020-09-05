package org.alphacat.leetcode.solution.easy.no1401to1500;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class No1469 {
    List<Integer> list;

    public List<Integer> getLonelyNodes(TreeNode root) {
        list = new LinkedList<>();
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        if (leftNode != null && rightNode == null) {
            list.add(leftNode.val);
        } else if (rightNode != null && leftNode == null) {
            list.add(rightNode.val);
        }
        preOrder(node.left);
        preOrder(node.right);
    }
}
