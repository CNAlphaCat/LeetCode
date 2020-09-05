package org.alphacat.leetcode.solution.easy.no101to200;


import org.alphacat.leetcode.datastructure.ListNode;

public class No141 {

    public boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = goOneStep(dummyHead);
        ListNode fast = goTwoStep(dummyHead);
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = goOneStep(slow);
            fast = goTwoStep(fast);
        }
        return false;
    }

    private ListNode goOneStep(ListNode node) {
        ListNode ans = node;
        if (ans == null) {
            return null;
        }
        return ans.next;
    }

    private ListNode goTwoStep(ListNode node) {
        ListNode ans = node;
        ans = goOneStep(ans);
        ans = goOneStep(ans);
        return ans;
    }
}
