package org.alphacat.leetcode.solution.classic.string;

public class No758 {
	public String boldWords(String[] words, String S) {
		if (S == null)
			return S;
		if (words.length == 0)
			return S;
		int m = S.length();
		if (m == 0)
			return S;
		boolean[] isBold = new boolean[m];// Ĭ��ֵfalse
		isBold = getIsBold(words, S, isBold, m);
		String res = getString(m, isBold, S);
		return res;
	}

	private String getString(int n, boolean[] isBold, String S) {
		StringBuilder sb = new StringBuilder();
		char c;
		boolean isHavePre = false;
		for (int i = 0; i < n - 1; ++i) {
			boolean crr = isBold[i];
			boolean next = isBold[i + 1];
			c = S.charAt(i);
			if (!isHavePre && crr && next) {
				isHavePre = true;
				sb.append("<b>");
				sb.append(c);
			} else if (isHavePre && crr && !next) {
				isHavePre = false;
				sb.append(c);
				sb.append("</b>");
			} else if (!isHavePre && crr && !next) {
				sb.append("<b>");
				sb.append(c);
				sb.append("</b>");
			} else {
				sb.append(c);
			}
		}
		if (!isHavePre && isBold[n - 1]) {
			sb.append("<b>");
			isHavePre = true;
		}
		c = S.charAt(n - 1);
		sb.append(c);
		if (isBold[n - 1] && isHavePre) {
			sb.append("</b>");
		}
		String res = sb.toString();
		return res;
	}

	private boolean[] getIsBold(String[] words, String S, boolean[] isBold, int m) {
		for (String temp : words) {
			int index = S.indexOf(temp);
			int star = index;
			while (index >= 0 && index < m) {
				int length = temp.length();
				for (int j = index; j < index + length; ++j) {
					isBold[j] = true;
				}
				star++;
				index = S.indexOf(temp, star);
			}
		}
		return isBold;
	}
}
