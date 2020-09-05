package org.alphacat.leetcode.solution.easy.no701to800;

public class No766 {

    int[][] matrix;
    int m;
    int n;

    public boolean isToeplitzMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        for (int i = m - 2; i >= 0; i--) {
            if (!isDiagonalToeplitz(i, 0)) {
                return false;
            }
        }
        for (int j = 1; j < n; j++) {
            if (!isDiagonalToeplitz(0, j)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalToeplitz(int i, int j) {
        int num = matrix[i][j];
        while (isInBorder(i, j)) {
            int tempNum = matrix[i][j];
            if (num != tempNum) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private boolean isInBorder(int i, int j) {
        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j >= n) {
            return false;
        }
        return true;
    }
}
