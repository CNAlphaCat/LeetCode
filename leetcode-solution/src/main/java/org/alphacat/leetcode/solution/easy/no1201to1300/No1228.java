package org.alphacat.leetcode.solution.easy.no1201to1300;

public class No1228 {
	public int missingNumber(int[] arr) {
		int diff1 = arr[1] - arr[0];
		int diff2 = arr[2] - arr[1];
		int diff = diff1;
		if (Math.abs(diff1) > Math.abs(diff2)) {
			diff = diff2;
		}
		int pre = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] - arr[i - 1] != diff) {
				pre = arr[i - 1];
			}
		}
		return pre + diff;
	}
}
