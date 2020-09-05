package org.alphacat.leetcode.solution.todo;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.Stack;

public class No173 {

    class BSTIterator {

        private Stack<TreeNode> stack;

        private void findMostLeft(TreeNode node) {
            TreeNode cur = node;
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            findMostLeft(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            findMostLeft(node.right);
            return node.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
