package org.alphacat.leetcode.solution.easy.no1101to1200;

public class No1119 {
	public String removeVowels(String S) {
		String res = S.replace("a", "");
		res = res.replace("e", "");
		res = res.replace("i", "");
		res = res.replace("o", "");
		res = res.replace("u", "");
		return res;
	}
}
