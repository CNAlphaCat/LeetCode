package org.alphacat.leetcode.solution.easy.no801to900;

public class No867 {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }
}
