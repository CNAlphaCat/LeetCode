package org.alphacat.leetcode.solution.easy.no1201to1300;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class No1243 {
	public List<Integer> transformArray(int[] arr) {
		boolean isChange = false;
		int n = arr.length;
		int[] temp = new int[n];
		initialTemp(temp, arr, n);
		while (true) {
			isChange = false;
			for (int i = 1; i < n - 1; ++i) {
				if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
					isChange = true;
					temp[i] = arr[i] - 1;
				} else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
					isChange = true;
					temp[i] = arr[i] + 1;
				} else {
					temp[i] = arr[i];
				}
			}
			if (!isChange) {
				break;
			} else {
				System.arraycopy(temp, 0, arr, 0, n);
			}
		}
		List<Integer> res = intArrToList(arr);
		return res;
	}

	private void initialTemp(int[] temp, int[] arr, int n) {
		temp[0] = arr[0];
		temp[n - 1] = arr[n - 1];
	}

	public List<Integer> intArrToList(int data[]) {
		IntStream is = Arrays.stream(data);
		Stream<Integer> s = is.boxed();
		List<Integer> res = s.collect(Collectors.toList());
		return res;
	}
}
