package org.alphacat.leetcode.solution.classic.binarysearch;

/**
 * https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/
 * 1283. 使结果不超过阈值的最小除数
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
public class No1283_smallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = findMax(nums);

        int ans = -1;

        while (l <= h) {
            int divideNum = l + ((h - l) >> 1);

            int sum = 0;
            for (int num : nums) {
                sum += (num - 1) / divideNum + 1;
            }

            if (sum <= threshold) {
                ans = divideNum;
                h = divideNum - 1;
            } else {
                l = divideNum + 1;
            }
        }
        return ans;
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
