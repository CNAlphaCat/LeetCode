package org.alphacat.leetcode.solution.classic.arr;

public class No807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxRow = new int[n];
        int[] maxColumn = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxColumn[j] = Math.max(maxColumn[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(maxRow[i], maxColumn[j]) - grid[i][j];
            }
        }
        return res;
    }
}
