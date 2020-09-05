package org.alphacat.leetcode.solution.easy.no601to700;

import java.util.HashMap;

public class No604 {

	public class StringIterator {
		char[] ch;
		int index;
		int[] arr;
		HashMap<Character, Integer> map;
		int size;

		public StringIterator(String compressedString) {
			setMap();
			int n = getSize(compressedString);
			initial(n);
			int l = compressedString.length();
			int b1 = 0, b2 = 0;
			for (int i = 0; i < l; ++i) {
				char c = compressedString.charAt(i);
				if (!isNum(c)) {
					ch[b1] = c;
					b1++;
				} else {
					int numCount = getCount(compressedString, i, l);
					int num = strToInt(compressedString, i, numCount);
					i = i + numCount - 1;
					arr[b2] = num;
					b2++;
				}
			}
		}

		public char next() {
			while (this.index < size && this.arr[index] <= 0) {
				index++;
			}
			if (index == size) {
				return ' ';
			}
			this.arr[index] = this.arr[index] - 1;
			return ch[index];
		}

		public boolean hasNext() {
			while (this.index < size && this.arr[index] <= 0) {
				index++;
			}
			if (this.index < this.size && arr[index] > 0) {
				return true;
			}
			return false;
		}

		private void initial(int n) {
			this.index = 0;
			this.ch = new char[n];
			this.arr = new int[n];
			this.size = n;
		}

		private boolean isNum(char c) {
			if (map.containsKey(c))
				return true;
			return false;
		}

		private void setMap() {
			this.map = new HashMap<Character, Integer>();
			map.put('1', 1);
			map.put('2', 2);
			map.put('3', 3);
			map.put('4', 4);
			map.put('5', 5);
			map.put('6', 6);
			map.put('7', 7);
			map.put('8', 8);
			map.put('9', 9);
			map.put('0', 0);
		}

		private int strToInt(String s, int begin, int count) {
			String temp = s.substring(begin, begin + count);
			return Integer.parseInt(temp);
		}

		private int getCount(String s, int begin, int n) {
			int count = 0;
			for (int i = begin; i < n; ++i) {
				char c = s.charAt(i);
				if (isNum(c)) {
					count++;
				} else {
					break;
				}
			}
			return count;
		}

		private int getSize(String s) {
			int count = 0;
			int n = s.length();
			for (int i = 0; i < n; ++i) {
				char c = s.charAt(i);
				if (!isNum(c)) {
					count++;
				}
			}
			return count;
		}
	}

	/*
	 * public class StringIterator { String string; int i; int n; HashMap<Character,
	 * Integer> map;
	 * 
	 * public StringIterator(String compressedString) { setMap(); int n =
	 * compressedString != null ? compressedString.length() : 0; StringBuilder sb =
	 * new StringBuilder(); char lastC = ' '; for (int i = 0; i < n; ++i) { char c =
	 * compressedString.charAt(i); if (!isNum(c)) { lastC = c; continue; } int
	 * numCount = getCount(compressedString, i, n); int num =
	 * strToInt(compressedString, i, numCount); i = i + numCount-1; for (int j = 0;
	 * j < num; ++j) { sb.append(lastC); } } this.string = sb.toString(); this.n =
	 * this.string.length(); this.i = 0; }
	 * 
	 * public char next() { if (i < n) { char c = this.string.charAt(i); this.i++;
	 * return c; } return ' '; }
	 * 
	 * public boolean hasNext() { if (i < n) { return true; } return false; }
	 * 
	 * private int getCount(String s, int begin, int n) { int count = 0; for (int i
	 * = begin; i < n; ++i) { char c = s.charAt(i); if (isNum(c)) { count++; } else
	 * { break; } } return count; }
	 * 
	 * private int strToInt(String s, int begin, int count) { String temp =
	 * s.substring(begin, begin + count); return Integer.parseInt(temp); }
	 * 
	 * private boolean isNum(char c) { if (map.containsKey(c)) return true; return
	 * false; }
	 * 
	 * private void setMap() { this.map = new HashMap<Character, Integer>();
	 * map.put('1', 1); map.put('2', 2); map.put('3', 3); map.put('4', 4);
	 * map.put('5', 5); map.put('6', 6); map.put('7', 7); map.put('8', 8);
	 * map.put('9', 9); map.put('0', 0); } }
	 */
}
