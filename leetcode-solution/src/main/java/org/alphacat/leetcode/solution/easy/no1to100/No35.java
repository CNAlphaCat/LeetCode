package org.alphacat.leetcode.solution.easy.no1to100;

public class No35 {
	public int searchInsert(int[] nums, int target) {
		int n = nums == null ? 0 : nums.length;
		int i = 0, j = n - 1,mid;
		while (i <= j) {
			mid = (i + j) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				j = mid-1;
			} else {
				i = mid+1;
			}
		}
		return i;
	}
}
