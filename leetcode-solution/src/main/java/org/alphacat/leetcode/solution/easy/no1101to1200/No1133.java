package org.alphacat.leetcode.solution.easy.no1101to1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1133 {
	public int largestUniqueNumber(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; ++i) {
			int temp = A[i];
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				int count = map.get(temp);
				count++;
				map.replace(temp, count);
			}
		}
		int res = -1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			if (count == 1) {
				int key = entry.getKey();
				res = Math.max(res, key);
			}
		}
		return res;
	}

	public int largestUniqueNumber_2(int[] A) {
		Arrays.sort(A);
		int n = A.length - 1;
		int max = A[n];
		int count = 1;
		for (int i = n - 1; i >= 0; --i) {
			if (A[i] != max && count == 1) {
				return max;
			} else if (A[i] == max) {
				count++;
			} else {
				max = A[i];
				count = 1;
			}
		}
		if (count == 1) {
			return max;
		}
		return -1;
	}
}
