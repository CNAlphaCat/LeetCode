package org.alphacat.leetcode.solution.easy.no201to300;

import java.util.Stack;

public class No232 {
    class MyQueue {
        Stack<Integer> outputStack;
        Stack<Integer> storageStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            outputStack = new Stack<>();
            storageStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!outputStack.isEmpty()) {
                int num = outputStack.pop();
                storageStack.add(num);
            }
            storageStack.add(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!outputStack.isEmpty()) {
                return outputStack.pop();
            }
            while (!storageStack.isEmpty()) {
                int num = storageStack.pop();
                outputStack.add(num);
            }
            return outputStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!outputStack.isEmpty()) {
                return outputStack.peek();
            }
            while (!storageStack.isEmpty()) {
                int num = storageStack.pop();
                outputStack.add(num);
            }
            return outputStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return storageStack.isEmpty() && outputStack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
