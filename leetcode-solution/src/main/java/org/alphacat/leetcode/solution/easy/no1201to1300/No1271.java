package org.alphacat.leetcode.solution.easy.no1201to1300;

import java.util.HashSet;

public class No1271 {
	public String toHexspeak(String num) {
		long intNum = Long.parseLong(num);
		String hex = Long.toHexString(intNum).toUpperCase();
		hex = hex.replace('0', 'O');
		hex = hex.replace('1', 'I');
		return getRes(hex);
	}

	private String getRes(String s) {
		HashSet<Character> set = getSet();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				return "ERROR";
			}
		}
		return s;
	}

	private HashSet<Character> getSet() {
		HashSet<Character> set = new HashSet<Character>();
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		set.add('E');
		set.add('F');
		set.add('O');
		set.add('I');
		return set;
	}
}
