package org.alphacat.leetcode.solution.easy.no1to100;

public class No66 {
	public int[] plusOne(int[] digits) {
		if (digits == null)
			return null;
		int n = digits.length;
		if (n == 0)
			return digits;
		int crr = -1;
		for (int i = n - 1; i >= 0; --i) {
			crr = digits[i];
			if (crr == 9) {
				digits[i] = 0;
			} else {
				digits[i] = digits[i] + 1;
				break;
			}
			if (i == 0) {
				int[] res = new int[n + 1];
				res[0] = 1;
				for (int j = 1; j < n; ++j) {
					res[j] = 0;
				}
				return res;
			}
		}
		return digits;
	}
}
