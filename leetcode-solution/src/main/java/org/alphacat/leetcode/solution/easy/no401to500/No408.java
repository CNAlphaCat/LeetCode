package org.alphacat.leetcode.solution.easy.no401to500;

public class No408 {
	public boolean validWordAbbreviation(String word, String abbr) {
		int n = word.length();
		int m = abbr.length();
		int i = 0, j = 0;
		while (i < n && j < m) {
			char c1 = word.charAt(i);
			char c2 = abbr.charAt(j);
			if (!isNum(c2) && c1 == c2) {
				i++;
				j++;
				continue;
			} else if (!isNum(c2) && c1 != c2) {
				return false;
			} else if (c2 == '0') {
				return false;
			}
			int numCount = getNumCount(abbr, j, m);
			String intString = abbr.substring(j, j + numCount);
			int num = Integer.parseInt(intString);
			j = j + numCount;
			i = i + num;
		}
		if (i == n && j == m)
			return true;
		return false;
	}

	boolean isNum(char c) {
		if (c == '1')
			return true;
		if (c == '2')
			return true;
		if (c == '3')
			return true;
		if (c == '4')
			return true;
		if (c == '5')
			return true;
		if (c == '6')
			return true;
		if (c == '7')
			return true;
		if (c == '8')
			return true;
		if (c == '9')
			return true;
		if (c == '0')
			return true;
		return false;
	}

	int getNumCount(String abbr, int begin, int m) {
		int numCount = 0;
		char c;
		for (int i = begin; i < m; i++) {
			c = abbr.charAt(i);
			if (isNum(c)) {
				numCount++;
			} else {
				break;
			}
		}
		return numCount;
	}
}
