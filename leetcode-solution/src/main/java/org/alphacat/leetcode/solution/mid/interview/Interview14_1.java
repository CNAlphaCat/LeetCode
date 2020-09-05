package org.alphacat.leetcode.solution.mid.interview;

public class Interview14_1 {
	public int cuttingRope(int n) {
		if (n <= 3)
			return n - 1;
		int a = n / 3, b = n % 3;
		if (b == 0)
			return (int) (Math.pow(3, a)) % 1000000007;
		if (b == 1)
			return (int) (Math.pow(3, a - 1) * 4) % 1000000007;
		return (int) (Math.pow(3, a) * 2) % 1000000007;
	}
}
