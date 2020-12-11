package org.alphacat.leetcode.solution.classic.tree.inorder;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 94. 二叉树的中序遍历
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No94_inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

    // 莫里斯遍历
    public List<Integer> inorderTraversal_2(TreeNode root) {
        TreeNode current = root;
        List<Integer> ans = new LinkedList<>();
        while (current != null) {
            if (current.left == null) {
                ans.add(current.val);
                current = current.right;
                continue;
            }
            TreeNode bottomRight = findBottomRight(current.left);
            bottomRight.right = current;
            TreeNode temp = current;
            current = current.left;
            temp.left = null;
        }
        return ans;
    }

    private TreeNode findBottomRight(TreeNode root) {
        TreeNode ans = root;
        while (ans.right != null) {
            ans = ans.right;
        }
        return ans;
    }
}
