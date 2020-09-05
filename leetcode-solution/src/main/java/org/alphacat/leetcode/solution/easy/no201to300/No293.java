package org.alphacat.leetcode.solution.easy.no201to300;

import java.util.LinkedList;
import java.util.List;

public class No293 {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new LinkedList<String>();
		char[] cs = s.toCharArray();
		int n = cs.length;
		for (int i = 1; i < n; ++i) {
			if (cs[i - 1] == '+' && cs[i] == '+') {
				cs[i - 1] = '-';
				cs[i] = '-';
				String temp = String.valueOf(cs);
				res.add(temp);
				// res.add(new String(cs));
				cs[i - 1] = '+';
				cs[i] = '+';
			}
		}
		return res;
	}

	public List<String> generatePossibleNextMoves_2(String s) {
		List<String> res = new LinkedList<String>();
		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < n; ++i) {
			if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
				sb.setCharAt(i - 1, '-');
				sb.setCharAt(i, '-');
				String temp = sb.toString();
				res.add(temp);
				sb.setCharAt(i - 1, '+');
				sb.setCharAt(i, '+');
			}
		}
		return res;
	}
}
