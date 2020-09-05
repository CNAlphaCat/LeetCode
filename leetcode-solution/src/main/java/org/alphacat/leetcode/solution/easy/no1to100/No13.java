package org.alphacat.leetcode.solution.easy.no1to100;

import java.util.HashMap;
import java.util.Map;

public class No13 {
	public int convert(String string) {
		int res = 0;
		Map<Character, Integer> map = getMap();
		int n = string.length();
		int crr = 0, next = 0;
		if(n==1) return map.get(string.charAt(0));
		for (int i = 0; i < n-1; i++) {
			crr = map.get(string.charAt(i));
			next = map.get(string.charAt(i+1));
			if(crr<next) res=res-crr;
			else res=res+crr;
			if (i == n - 2) {
				res = res + next;
			}
		}
		return res;
	}

	private Map<Character, Integer> getMap() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}
}
