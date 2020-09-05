package org.alphacat.leetcode.solution.classic.arr;

import java.util.Arrays;

public class No1099 {
	public int twoSumLessThanK(int[] A, int K) {
		Arrays.sort(A);
		int i = 0, j = A.length - 1;
		int res = -1;
		while (i < j) {
			int sum = A[i] + A[j];
			if (sum >= K) {
				j--;
			} else {
				res = Math.max(res, sum);
				i++;
			}
		}
		return res;
	}
}
