package org.alphacat.leetcode.solution.easy.no701to800;

import java.util.HashSet;
import java.util.List;

public class No734 {
	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
		int m = words1.length;
		int n = words2.length;
		if (m != n)
			return false;
		HashSet<String> set = new HashSet<String>();
		int l = pairs.size();
		for (int i = 0; i < l; ++i) {
			List<String> tempList = pairs.get(i);
			String s1 = tempList.get(0);
			String s2 = tempList.get(1);
			set.add(getPairString(s1, s2));
			set.add(getPairString(s2, s1));
		}
		for (int i = 0; i < m; ++i) {
			String s3 = words1[i];
			String s4 = words2[i];
			if (!isPair(s3, s4, set)) {
				return false;
			}
		}
		return true;
	}

	public boolean isPair(String s1, String s2, HashSet<String> set) {
		if (s1.equals(s2))
			return true;
		if (set.contains(getPairString(s1, s2)))
			return true;
		return false;
	}

	public String getPairString(String s1, String s2) {
		return s1 + ',' + s2;
	}
}
