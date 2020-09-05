package org.alphacat.leetcode.solution.classic.string;

import java.util.HashSet;


public class Offer38 {
	private char[] c;
	private HashSet<String> set;
	private int length;

	public String[] permutation(String s) {
		initial(s);
		permute(0);
		String[] res = new String[set.size()];
		return set.toArray(res);
	}

	private void initial(String s) {
		this.set = new HashSet<String>();
		this.c = s.toCharArray();
		this.length = c.length;
	}

	private void permute(int i) {
		String temp = String.valueOf(c);
		if (i == length - 1 && !set.contains(temp)) {
			set.add(temp);
		}
		for (int j = i; j < this.length; ++j) {
			swap(i, j);
			permute(i + 1);
			swap(i, j);
		}
	}

	private void swap(int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}
