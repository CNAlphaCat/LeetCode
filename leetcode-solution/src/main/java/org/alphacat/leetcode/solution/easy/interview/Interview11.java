package org.alphacat.leetcode.solution.easy.interview;

import java.util.Arrays;

public class Interview11 {

	public int minArray(int[] numbers) {
		int index = 0;
		int n = numbers.length;
		while (index < n - 1 && numbers[index + 1] >= numbers[index]) {
			index++;
		}
		reverse(numbers, 0, n - 1);
		reverse(numbers, 0, n - index - 2);
		reverse(numbers, n - index - 1, n - 1);
		return numbers[0];
	}

	private void reverse(int[] n, int b, int e) {
		while (b < e) {
			swap(n, b, e);
			b++;
			e--;
		}
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public int minArray_2(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[0];
	}

}
