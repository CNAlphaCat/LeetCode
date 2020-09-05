package org.alphacat.leetcode.solution.classic.matrix;

public class No48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void rotate_2(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        reverse(matrix, n);
        reverseByCentralLine(matrix, n);
    }

    private void reverseByCentralLine(int[][] matrix, int n) {
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    private void reverse(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
