package org.alphacat.leetcode.solution.easy.no1101to1200;

import java.util.Arrays;

public class No1196 {
	public int maxNumberOfApples(int[] arr) {
		Arrays.sort(arr);
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (sum + arr[i] < 5000) {
				max++;
				sum += arr[i];
			} else {
				break;
			}
		}
		return max;
	}
}
