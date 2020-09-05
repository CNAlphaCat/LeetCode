package org.alphacat.leetcode.solution.easy.no1to100;

public class No26 {
	public int removeDuplicates(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int n=nums.length;
		if(n==1) return 1;
		int pre=nums[0];
		int crr=0;
		int duplicates=0;
		for(int i=1;i<n;i++) {
			crr=nums[i];
			if(crr==pre) {
				duplicates++;
			}
			else {
				nums[i-duplicates]=nums[i];
			}
			pre=nums[i];
		}
		return n-duplicates;
	}
}
