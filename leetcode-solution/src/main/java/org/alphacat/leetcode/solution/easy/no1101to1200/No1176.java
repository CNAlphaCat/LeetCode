package org.alphacat.leetcode.solution.easy.no1101to1200;

public class No1176 {

	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int n = calories.length;
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			int point = getPoint(calories, k, lower, upper, i, n);
			sum += point;
		}
		return sum;
	}

	private int getPoint(int[] calories, int k, int lower, int upper, int i, int n) {
		if (i + k - 1 >= n)
			return 0;
		int sum = getSum(calories, k, i, n);
		if (sum > upper)
			return 1;
		else if (sum < lower)
			return -1;
		return 0;
	}

	private int getSum(int[] calories, int k, int i, int n) {
		int sum = 0;
		for (int index = i; index < i + k; ++index) {
			sum += calories[index];
		}
		return sum;
	}

	public int dietPlanPerformance_2(int[] calories, int k, int lower, int upper) {
		int n = calories.length;
		return dietPlanPerformance(calories, k, lower, upper, 0, calories.length - 1, n);
	}

	private int dietPlanPerformance(int[] calories, int k, int lower, int upper, int i, int j, int n) {
		if (i >= n)
			return 0;
		if (i + k - 1 >= n)
			return 0;
		if (j - i + 1 == k) {
			int sum = 0;
			for (; i <= j; i++) {
				sum += calories[i];
			}
			if (sum < lower)
				return -1;
			else if (sum > upper)
				return 1;
			else {
				return 0;
			}
		}
		int sum1 = dietPlanPerformance(calories, k, lower, upper, i, i + k - 1, n);
		int sum2 = dietPlanPerformance(calories, k, lower, upper, i + k, j, n);
		return sum1 + sum2;
	}
}
