package org.alphacat.leetcode.solution.easy.no1401to1500;

public class No1480 {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
