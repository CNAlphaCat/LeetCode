package org.alphacat.leetcode.solution.todo;

public class Interview19 {

	public boolean isMatch(String s, String p) {
		int lengthOfS = s.length();
		int lengthOfP = p.length();
		int i1 = lengthOfS - 1;
		int i2 = lengthOfP - 1;

		int indexDotStar = p.indexOf(".*");
		if (indexDotStar >= 0) {
			for (int i = 0; i < lengthOfS; ++i) {
				if (isPreMatch(s, p, i, indexDotStar - 1)) {
					if (isPostMatch(s, p, i + 1, indexDotStar + 2, lengthOfS, lengthOfP)) {
						return true;
					}
				}
			}
			return false;
		}

		while (i1 >= 0 && i2 >= 0) {
			char c1 = s.charAt(i1);
			char c2 = p.charAt(i2);
			if (c2 == '.' || c1 == c2) {
				i1--;
				i2--;
			} else if (c2 == '*') {
				i2--;
				if (i2 < 0) {
					return false;
				}
				c2 = p.charAt(i2);
				if (c1 == c2) {
					int i = i1;
					String tempS;
					String tempP = p.substring(0, i2);
					while (i >= 0 && s.charAt(i) == c2) {
						tempS = s.substring(0, i + 1);
						if (isMatch(tempS, tempP)) {
							return true;
						}
						tempS = tempS.substring(0, i);
						if (i == 0 && s.charAt(i) == c2 && isMatch(tempS, tempP)) {
							return true;
						}
						--i;
					}
					tempS = s.substring(0, i + 1);
					if (isMatch(tempS, tempP)) {
						return true;
					}
				}
				i2--;
			} else {
				return false;
			}
		}
		while (i2 >= 0) {
			char c2 = p.charAt(i2);
			if (c2 == '*' && i2 - 1 >= 0) {
				i2 = i2 - 2;
			} else {
				break;
			}
		}
		if (i1 < 0 && i2 < 0)
			return true;
		return false;
	}

	private boolean isPreMatch(String s, String p, int e1, int e2) {
		if (e2 <= 0) {
			return true;
		}
		String tempP = p.substring(0, e2);
		if (tempP.equals("")) {
			return true;
		}
		for (int i = e1; i >= 0; --i) {
			String tempS = s.substring(0, i + 1);
			if (isMatch(tempS, tempP)) {
				return true;
			}
		}
		return false;
	}

	private boolean isPostMatch(String s, String p, int b1, int b2, int lengthOfS, int lengthOfP) {
		if (lengthOfP <= 0) {
			return true;
		}
		String tempP = p.substring(b2, lengthOfP);
		if (tempP.equals("")) {
			return true;
		}
		for (int i = b1; i < lengthOfS; ++i) {
			String tempS = s.substring(i, lengthOfS);
			if (isMatch(tempS, tempP)) {
				return true;
			}
		}
		return false;
	}
}
