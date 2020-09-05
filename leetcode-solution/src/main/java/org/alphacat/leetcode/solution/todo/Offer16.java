package org.alphacat.leetcode.solution.todo;

public class Offer16 {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		}
		if (n % 2 == 0) {
			double d = myPow(x, n / 2);
			return d * d;
		} else {
			double d = myPow(x, n / 2);
			if (n < 0) {
				x = 1 / x;
			}
			return d * d * x;
		}
	}
}
