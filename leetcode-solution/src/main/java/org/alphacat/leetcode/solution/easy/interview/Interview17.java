package org.alphacat.leetcode.solution.easy.interview;

public class Interview17 {
	public int[] printNumbers(int n) {
		final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
		int maxNum = sizeTable[n - 1];
		int[] res = new int[maxNum];
		for (int i = 0; i < maxNum; ++i) {
			res[i] = i + 1;
		}
		return res;
	}
}
