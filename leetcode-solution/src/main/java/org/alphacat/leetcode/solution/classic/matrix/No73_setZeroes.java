package org.alphacat.leetcode.solution.classic.matrix;

public class No73_setZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isZero = false;


        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                isZero = true;
            }

            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (isZero) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
