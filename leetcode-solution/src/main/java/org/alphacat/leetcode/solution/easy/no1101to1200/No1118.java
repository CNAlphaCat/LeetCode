package org.alphacat.leetcode.solution.easy.no1101to1200;

import java.util.HashMap;

public class No1118 {
	public int numberOfDays(int Y, int M) {
		if (M == 2) {
			return leapYearMonth(Y);
		}
		HashMap<Integer, Integer> map = getMap();
		return map.get(M);
	}

	private int leapYearMonth(int Y) {
		if (isLeapYear(Y))
			return 29;
		return 28;
	}

	private boolean isLeapYear(int Y) {
		if (Y % 100 != 0 && Y % 4 == 0) {
			return true;
		}
		if (Y % 400 == 0) {
			return true;
		}
		return false;
	}

	private HashMap<Integer, Integer> getMap() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 31);
		map.put(2, 28);
		map.put(3, 31);
		map.put(4, 30);
		map.put(5, 31);
		map.put(6, 30);
		map.put(7, 31);
		map.put(8, 31);
		map.put(9, 30);
		map.put(10, 31);
		map.put(11, 30);
		map.put(12, 31);
		return map;
	}
}
