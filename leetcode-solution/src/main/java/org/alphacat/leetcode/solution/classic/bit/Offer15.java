package org.alphacat.leetcode.solution.classic.bit;

public class Offer15 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >>> 1;
		}
		return count;
	}

	public int hammingWeight_2(int n) {
		String s = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
}
