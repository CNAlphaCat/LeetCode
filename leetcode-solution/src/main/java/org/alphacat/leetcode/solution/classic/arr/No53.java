package org.alphacat.leetcode.solution.classic.arr;

public class No53 {
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int crrSum = nums[0];
		int maxSum = nums[0];
		int temp = nums[0];
		for (int i = 1; i < n; ++i) {
			temp = crrSum + nums[i];
			crrSum = Math.max(nums[i], temp);
			maxSum = Math.max(crrSum, maxSum);
		}
		return maxSum;
	}
}
