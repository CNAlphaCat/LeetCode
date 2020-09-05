package org.alphacat.leetcode.solution.easy.no1001to1100;

public class No1064 {
	public int fixedPoint(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			if (A[i] == i) {
				return i;
			}
		}
		return -1;
	}
	
	public int fixedPoint_2(int[] A) {
		int n = A.length;
		int i = 0, j = n - 1, mid;
		while (i <= j) {
			mid = (i + j) / 2;
			if (A[mid] == mid) {
				return mid;
			} else if (A[mid] > mid) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return -1;
	}
}
