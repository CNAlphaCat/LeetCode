package org.alphacat.leetcode.solution.classic.listnode.reverse;


import org.alphacat.leetcode.datastructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class No234_isPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddle(head);
        reverse(mid);
        ListNode p = head;
        ListNode q = mid.next;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private void reverse(ListNode node) {
        ListNode current = node.next;
        node.next = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = node.next;
            node.next = current;
            current = nextNode;
        }
    }

    private ListNode getMiddle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while (fast != null && fast.next != null) {
            fast = twoStep(fast);
            slow = slow.next;
        }
        return slow;
    }

    private ListNode twoStep(ListNode node) {
        ListNode ans;
        ans = node.next;
        if (ans.next != null) {
            ans = ans.next;
        } else {
            ans = null;
        }
        return ans;
    }

    public boolean isPalindrome_deque(ListNode head) {
        ListNode current = head;
        Deque<ListNode> queue = new LinkedList<>();
        while (current != null) {
            queue.offer(current);
            current = current.next;
        }
        while (!queue.isEmpty() && queue.size() > 1) {
            ListNode pre = queue.pollFirst();
            ListNode post = queue.pollLast();
            if (pre.val != post.val) {
                return false;
            }
        }
        return true;
    }
}
