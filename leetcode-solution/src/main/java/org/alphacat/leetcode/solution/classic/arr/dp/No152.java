package org.alphacat.leetcode.solution.classic.arr.dp;

public class No152 {

    private int NULL_NUM = 0;

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return NULL_NUM;
        }
        int ans = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num * max, num);
            min = Math.min(num * min, num);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
