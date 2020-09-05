package org.alphacat.leetcode.solution.easy.no1101to1200;

public class No1134 {
	public boolean isArmstrong(int N) {
		int sum = 0;
		int temp = N;
		int length = sizeOfInt(N);
		while (temp > 0) {
			int tempNum = temp % 10;
			sum += Math.pow(tempNum, length);
			temp = temp / 10;
		}
		if (sum == N) {
			return true;
		}
		return false;
	}

	public static int sizeOfInt(int x) {
		final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
		for (int i = 0;; i++) {
			if (x <= sizeTable[i]) {
				return i + 1;
			}
		}
	}
}
