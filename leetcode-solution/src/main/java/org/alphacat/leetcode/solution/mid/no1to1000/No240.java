package org.alphacat.leetcode.solution.mid.no1to1000;

public class No240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (j < n && i >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --i;
            } else if (matrix[i][j] < target) {
                ++j;
            }
        }
        return false;
    }
}
