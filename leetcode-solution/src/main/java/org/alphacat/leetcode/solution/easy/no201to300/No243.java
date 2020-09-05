package org.alphacat.leetcode.solution.easy.no201to300;

public class No243 {
	public int shortestDistance(String[] words, String word1, String word2) {
		int n = words.length;
		int res = Integer.MAX_VALUE;
		int p1 = -1, p2 = -1;
		for (int i = 0; i < n; ++i) {
			if (words[i].equals(word1)) {
				p1 = i;
			}
			if (words[i].equals(word2)) {
				p2 = i;
			}
			if (p1 != -1 && p2 != -1) {
				res = Math.min(Math.abs(p1 - p2), res);
			}
		}
		return res;
	}
}
