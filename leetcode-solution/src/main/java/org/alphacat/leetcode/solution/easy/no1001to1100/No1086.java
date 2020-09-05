package org.alphacat.leetcode.solution.easy.no1001to1100;

import java.util.*;

public class No1086 {
	public int[][] highFive(int[][] items) {
		Arrays.sort(items, new cmp());
		Queue<int[]> queue = new LinkedList<int[]>();
		HashSet<Integer> set = new HashSet<Integer>();
		int n = items.length;
		for (int i = 0; i < n; ++i) {
			int student = items[i][0];
			int sum = 0;
			if (!set.contains(student)) {
				set.add(student);
				int[] sArr = new int[2];
				for (int j = 0; j < 5; ++j) {
					sum += items[i + j][1];
				}
				sArr[0] = student;
				sArr[1] = sum / 5;
				queue.add(sArr);
			}
		}
		int size = queue.size();
		int[][] res = new int[size][2];
		for (int i = 0; i < size; ++i) {
			int[] temp = queue.poll();
			res[i] = temp;
		}
		return res;
	}

	private class cmp implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			int diff = o1[0] - o2[0];
			if (diff == 0) {
				return o2[1] - o1[1];
			}
			return diff;
		}
	}
}
