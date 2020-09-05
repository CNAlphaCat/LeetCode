package org.alphacat.leetcode.solution.easy.interview;

public class Interview21 {
	public int[] exchange(int[] nums) {
		int n=nums.length;
		int i=0,j=n-1;
		while(i<j) {
			while(i<j && isOdd(nums[i])) i++;
			while(i<j && isEven(nums[j])) j--;
			nums= exchangeArr(nums, i, j);
		}
		return nums;
    }
	
	int[] exchangeArr(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
		return nums;
	}
	
	boolean isOdd(int i){
		if(i%2==1) return true;
		return false;
	}
	
	boolean isEven(int i){
		if(i%2==0) return true;
		return false;
	}
}
