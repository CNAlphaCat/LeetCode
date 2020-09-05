package org.alphacat.leetcode.solution.classic.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class No1065 {
	public int[][] indexPairs(String text, String[] words) {
		Stack<int[]> stack = new Stack<int[]>();
		MyCmp cmp = new MyCmp();
		int n = text.length();
		int i = 0;
		for (String s : words) {
			while (i >= 0 && i < n) {
				i = text.indexOf(s, i);
				if (i >= 0) {
					int[] temp = new int[2];
					temp[0] = i;
					int sLength = s.length();
					int end = i + sLength - 1;
					temp[1] = end;
					stack.add(temp);
					++i;
				}
			}
			i = 0;
		}
		int size = stack.size();
		int[][] res = new int[size][2];
		for (int j = size - 1; j >= 0; --j) {
			int[] temp = stack.pop();
			res[j][0] = temp[0];
			res[j][1] = temp[1];
		}
		Arrays.sort(res, cmp);
		return res;
	}

	private class MyCmp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			int diff = o1[0] - o2[0];
			if (diff == 0) {
				return o1[1] - o2[1];
			}
			return diff;
		}
	}
}
