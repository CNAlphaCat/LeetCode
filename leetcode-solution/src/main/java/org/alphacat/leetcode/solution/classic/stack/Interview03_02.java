package org.alphacat.leetcode.solution.classic.stack;

import java.util.Stack;

public class Interview03_02 {

    class MinStack {

        class Node {
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
                return;
            }
            int min = Math.min(head.min, x);
            head = new Node(x, min, head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    class MinStack_2 {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack_2() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
                return;
            }
            int peekNum = minStack.peek();
            if (peekNum < x) {
                minStack.push(peekNum);
                return;
            }
            minStack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
