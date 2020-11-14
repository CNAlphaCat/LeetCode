package org.alphacat.leetcode.solution.classic.arr.dp;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 152. 乘积最大子数组
 * keyword:子数组
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 */
public class No152_maxProduct {

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
