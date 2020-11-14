package org.alphacat.leetcode.solution.classic.string.dp;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 10. 正则表达式匹配
 * ☆☆☆☆
 * keyword:dp，正则，字符串匹配
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * 剑指 Offer 19. 正则表达式匹配
 * {@link  org.alphacat.leetcode.solution.hard.Offer19}
 *
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No10_isMatch {

    private final static char STAR = '*';
    private final static char DOT = '.';

    public boolean isMatch(String s, String p) {
        int m = s != null ? s.length() : 0;
        int n = p != null ? p.length() : 0;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                if (c == STAR) {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                    continue;
                }

                if (isMatch(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == DOT) {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
