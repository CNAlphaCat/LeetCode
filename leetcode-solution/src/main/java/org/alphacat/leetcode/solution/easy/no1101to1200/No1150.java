package org.alphacat.leetcode.solution.easy.no1101to1200;

public class No1150 {
	public boolean isMajorityElement(int[] nums, int target) {
		int n = nums.length;
		int i = 0, count = 0;
		while (i < n && nums[i] != target) {
			i++;
		}
		while (i < n && nums[i] == target) {
			count++;
			i++;
		}
		if (count > n / 2) {
			return true;
		}
		return false;
	}
}
