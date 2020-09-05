package org.alphacat.leetcode.solution.easy.no701to800;

import java.util.HashMap;

public class No760 {
	public int[] anagramMappings(int[] A, int[] B) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = B.length;
		for (int i = 0; i < n; ++i) {
			map.put(B[i], i);
		}
		int[] res = new int[n];
		for (int i = 0; i < n; ++i) {
			res[i] = map.get(A[i]);
		}
		return res;
	}
}
