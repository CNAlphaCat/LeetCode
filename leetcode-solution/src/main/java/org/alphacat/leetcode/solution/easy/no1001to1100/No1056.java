package org.alphacat.leetcode.solution.easy.no1001to1100;

import java.util.HashMap;

public class No1056 {
	public boolean confusingNumber(int N) {
		HashMap<Character, Character> map = getMap();
		String s = Integer.toString(N);
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; --i) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			}
			char temp = map.get(c);
			sb.append(temp);
		}
		String reverse = getString(sb);
		if (!reverse.equals(s)) {
			return true;
		}
		return false;
	}

	private String getString(StringBuilder sb) {
		int n = sb.length(), i = 0;
		while (i < n && sb.charAt(i) == '0') {
			++i;
		}
		if (i == n) {
			return "0";
		}
		String reverse = sb.substring(i, n);
		return reverse;
	}

	private HashMap<Character, Character> getMap() {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		return map;
	}
}
