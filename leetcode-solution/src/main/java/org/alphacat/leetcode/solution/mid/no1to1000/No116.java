package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.LinkedList;
import java.util.Queue;

public class No116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        if (left != null) {
            left.next = right;
        }
        Node next = root.next;
        if (right != null && next != null) {
            right.next = next.left;
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }

    public Node connect_2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node preNode = null;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (preNode != null) {
                    preNode.next = node;
                }
                preNode = node;
            }
            preNode = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
