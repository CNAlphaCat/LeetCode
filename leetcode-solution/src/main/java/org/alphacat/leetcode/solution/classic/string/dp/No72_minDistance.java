package org.alphacat.leetcode.solution.classic.string.dp;

public class No72_minDistance {

    //☆☆☆☆☆
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; ++j) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                int insert_1 = dp[i - 1][j] + 1;
                int insert_2 = dp[i][j - 1] + 1;
                int modify = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    ++modify;
                }
                dp[i][j] = getMin(insert_1, insert_2, modify);
            }
        }
        return dp[m][n];
    }

    private int getMin(int a, int b, int c) {
        int res = a;
        res = Math.min(res, b);
        res = Math.min(res, c);
        return res;
    }
}
