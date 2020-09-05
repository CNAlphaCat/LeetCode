package org.alphacat.leetcode.solution.easy.no1101to1200;

import java.util.HashMap;

public class No1165 {
	public int calculateTime(String keyboard, String word) {
		HashMap<Character, Integer> map = getMap(keyboard);
		int sum = 0, pre = 0;
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			int crr = map.get(c);
			sum += Math.abs(crr - pre);
			pre = crr;
		}
		return sum;
	}

	private HashMap<Character, Integer> getMap(String keyboard) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < keyboard.length(); ++i) {
			char c = keyboard.charAt(i);
			map.put(c, i);
		}
		return map;
	}
}
