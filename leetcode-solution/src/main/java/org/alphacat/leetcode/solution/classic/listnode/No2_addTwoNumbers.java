package org.alphacat.leetcode.solution.classic.listnode;


import org.alphacat.leetcode.datastructure.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 2. 两数相加
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l = new ListNode(0);
        ListNode crr = l;

        int j = 0;

        while (l1 != null || l2 != null || j != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + j;
            int n = sum % 10;
            j = sum / 10;

            crr.next = new ListNode(n);
            crr = crr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return l.next;
    }
}
