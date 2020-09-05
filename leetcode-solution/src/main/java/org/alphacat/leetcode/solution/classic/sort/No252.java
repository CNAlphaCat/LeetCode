package org.alphacat.leetcode.solution.classic.sort;

import java.util.Arrays;
import java.util.Comparator;

public class No252 {
	public boolean canAttendMeetings(int[][] intervals) {
		iSort isort=new iSort();
		Arrays.sort(intervals,isort);
		int n=intervals.length;
		for(int i=1;i<n;++i) {
			if(intervals[i-1][1]>intervals[i][0]) {
				return false;
			}
		}
		return true;
	}
	
	private class iSort implements Comparator<int []>{

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[0]-o2[0];
		}
		
	}
}
