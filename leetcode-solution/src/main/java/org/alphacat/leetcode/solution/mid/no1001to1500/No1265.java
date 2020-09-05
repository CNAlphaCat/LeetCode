package org.alphacat.leetcode.solution.mid.no1001to1500;

import java.util.Stack;

public class No1265 {
    // This is the ImmutableListNode's API interface.
    // You should not implement it, or speculate about its implementation.
    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            ImmutableListNode node = stack.pop();
            node.printValue();
        }
    }

    public void printLinkedListInReverse_2(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
