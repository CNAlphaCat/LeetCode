package org.alphacat.leetcode.solution.easy.interview;

public class Interview10 {

	public int fib(int n) {
		if (n == 0)
			return 0;
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		return fibCount(n, arr);
	}

	public int fibCount(int n, int[] arr) {
		if (n < 2)
			return arr[n];
		if (arr[n] > 0)
			return arr[n];
		arr[n] = (fibCount(n - 1, arr) + fibCount(n - 2, arr)) % 1000000007;
		return arr[n];
	}

	public int numWays(int n) {
		int a = 1, b = 1, res = 0;
		for (int i = 0; i < n; i++) {
			res = (a + b) % 1000000007;
			a = b;
			b = res;
		}
		return a;
	}
}
