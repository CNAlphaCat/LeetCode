package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.Stack;

public class No19_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i <= n; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode post = slow.next;
        slow.next = post.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd_stack(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        Stack<ListNode> stack = new Stack<>();
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
        for (int i = 0; i <= n; ++i) {
            current = stack.pop();
        }
        ListNode post = current.next;
        current.next = post.next;
        return dummyHead.next;
    }
}
