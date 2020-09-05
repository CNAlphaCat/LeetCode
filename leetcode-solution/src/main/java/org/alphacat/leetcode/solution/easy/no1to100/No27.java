package org.alphacat.leetcode.solution.easy.no1to100;

public class No27 {
	public int removeElement(int[] nums, int val) {
		if(nums==null || nums.length==0) return 0;
		int valCount=0;
		int n=nums.length;
		for(int i=0;i<n;i++) {
			if(nums[i]==val) {
				valCount++;
			}
			else {
				nums[i-valCount]=nums[i];
			}
		}
		return n-valCount;
    }
}
