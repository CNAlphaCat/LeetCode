package org.alphacat.leetcode.solution.mid.no1to1000;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.Stack;

public class No445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);

        ListNode head = new ListNode(0);

        int advance = 0;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + advance;
            advance = sum / 10;
            sum %= 10;
            addToHead(head, sum);
        }

        while (!s1.isEmpty()) {
            int sum = s1.pop()+ advance;
            advance = sum / 10;
            sum %= 10;
            addToHead(head, sum);
        }

        while (!s2.isEmpty()) {
            int sum = s2.pop()+ advance;
            advance = sum / 10;
            sum %= 10;
            addToHead(head, sum);
        }

        if (advance > 0) {
            addToHead(head, advance);
        }

        return head.next;
    }

    private void addToHead(ListNode head, int val) {
        if (head == null) {
            return;
        }
        ListNode next = head.next;
        ListNode cur = new ListNode(val);
        head.next = cur;
        cur.next = next;
    }

    private Stack<Integer> getStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = listNode;
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        return stack;
    }
}
