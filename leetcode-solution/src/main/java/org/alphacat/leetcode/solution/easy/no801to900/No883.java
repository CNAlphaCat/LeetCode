package org.alphacat.leetcode.solution.easy.no801to900;

public class No883 {

    public int projectionArea(int[][] grid) {
        int sum = 0;
        int n = grid.length;
        int bottom = 0;
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxColumn = 0;
            for (int j = 0; j < n; j++) {
                maxColumn = Math.max(maxColumn, grid[i][j]);
                maxRow = Math.max(maxRow, grid[j][i]);
                if (grid[i][j] != 0) {
                    bottom++;
                }
            }
            sum += maxColumn + maxRow;
        }
        return sum + bottom;
    }
}
