package org.alphacat.leetcode.solution.easy.no201to300;

import java.util.HashSet;

public class No266 {
	public boolean canPermutePalindrome(String s) {
		HashSet<Character> set = new HashSet<Character>();
		int n = s.length();
		char c;
		for (int i = 0; i < n; ++i) {
			c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
			} else {
				set.remove(c);
			}
		}
		return set.size() <= 1 ? true : false;
	}
}
