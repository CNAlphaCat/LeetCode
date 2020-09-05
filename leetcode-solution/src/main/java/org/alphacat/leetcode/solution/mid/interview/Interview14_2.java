package org.alphacat.leetcode.solution.mid.interview;

public class Interview14_2 {
	public int cuttingRope(int n) {
		if (n == 3)
			return 2;
		if (n == 2)
			return 1;
		int mod = 1000000007;
		long res = 1;
		while (n > 4) {
			res *= 3;
			res %= mod;
			n -= 3;
		}
		return (int) ((res * n) % mod);
	}
}
