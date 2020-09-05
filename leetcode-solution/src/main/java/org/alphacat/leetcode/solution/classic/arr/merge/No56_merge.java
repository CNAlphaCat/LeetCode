package org.alphacat.leetcode.solution.classic.arr.merge;

import java.util.Arrays;
import java.util.Stack;

public class No56_merge {

    private int BEGIN = 0;
    private int END = 1;

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            int[] preInterval = stack.peek();
            if (preInterval[END] < intervals[i][BEGIN]) {
                stack.push(intervals[i]);
                continue;
            }
            if (preInterval[END] < intervals[i][END]) {
                preInterval[END] = intervals[i][END];
            }
        }
        int n = stack.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; ++i) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
