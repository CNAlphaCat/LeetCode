package org.alphacat.leetcode.solution.easy.no1001to1100;

public class No1085 {
	public int sumOfDigits(int[] A) {
		int n = A.length;
		int min = A[0];
		for (int i = 1; i < n; ++i) {
			min = Math.min(min, A[i]);
		}
		int res = getSum(min);
		return oddOrEven(res);
	}

	private int getSum(int a) {
		int sum = 0;
		while (a > 0) {
			int temp = a % 10;
			sum += temp;
			a = a / 10;
		}
		return sum;
	}

	private int oddOrEven(int a) {
		if (a % 2 == 0)
			return 1;
		return 0;
	}
}
