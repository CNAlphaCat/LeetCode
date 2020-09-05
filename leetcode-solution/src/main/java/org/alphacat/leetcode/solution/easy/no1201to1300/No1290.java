package org.alphacat.leetcode.solution.easy.no1201to1300;


import org.alphacat.leetcode.datastructure.ListNode;

public class No1290 {
    public int getDecimalValue(ListNode head) {
        dataHelper helper = getValue(head);
        return helper.res;
    }

    private dataHelper getValue(ListNode head) {
        dataHelper helper;
        if (head == null) {
            helper = new dataHelper(0, 1);
            return helper;
        }
        helper = getValue(head.next);
        helper.res += helper.baseNum * head.val;
        helper.baseNum *= 2;
        return helper;
    }

    private class dataHelper {
        int res;
        int baseNum;

        public dataHelper(int _res, int _baseNum) {
            this.res = _res;
            this.baseNum = _baseNum;
        }
    }
}
