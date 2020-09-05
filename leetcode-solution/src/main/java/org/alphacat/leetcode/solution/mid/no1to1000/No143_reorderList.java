package org.alphacat.leetcode.solution.mid.no1to1000;

import org.alphacat.leetcode.datastructure.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 143. 重排链表
 * ☆☆☆☆
 * 链表，逆置，排列
 */
public class No143_reorderList {

    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        boolean isOdd = false;
        while (fast != null && fast.next != null) {
            slow = oneStep(slow);
            fast = twoStep(fast);
            if (fast == null) {
                isOdd = true;
            }
        }
        reverse(slow);
        ListNode head_front = head;
        ListNode head_post = slow.next;
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        while (head_front != null && head_post != null) {
            ListNode nextFront = head_front.next;
            ListNode nextPost = head_post.next;

            p.next = head_front;
            p = p.next;
            p.next = head_post;
            p = p.next;
            head_front = nextFront;
            head_post = nextPost;
        }
        if (isOdd) {
            p.next = head_front;
            p = p.next;
            p.next = null;
        }
        head = ans.next;
    }

    private void reverse(ListNode root) {
        ListNode p = root.next;
        root.next = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = root.next;
            root.next = p;
            p = next;
        }
    }

    private ListNode oneStep(ListNode node) {
        return node == null ? null : node.next;
    }

    private ListNode twoStep(ListNode node) {
        ListNode temp = oneStep(node);
        return oneStep(temp);
    }
}
