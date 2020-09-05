package org.alphacat.leetcode.solution.classic.stack;

import java.util.LinkedList;
import java.util.Queue;

public class No225 {
    class MyStack {

        Queue<Integer> queueStorage;
        Queue<Integer> queueOutput;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queueStorage = new LinkedList<>();
            queueOutput = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queueOutput.offer(x);
            while (queueOutput.size() > 1) {
                int num = queueOutput.poll();
                queueStorage.offer(num);
            }
        }

        private void exchangeQueue() {
            Queue<Integer> temp = queueStorage;
            queueStorage = queueOutput;
            queueOutput = temp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int num = queueOutput.poll();
            while (queueStorage.size() > 1) {
                int tempNum = queueStorage.poll();
                queueOutput.offer(tempNum);
            }
            exchangeQueue();
            return num;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queueOutput.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queueOutput.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
