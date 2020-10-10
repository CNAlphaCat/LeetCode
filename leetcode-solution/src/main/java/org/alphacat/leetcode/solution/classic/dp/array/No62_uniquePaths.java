package org.alphacat.leetcode.solution.classic.dp.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 * ☆☆☆☆
 * keyword:动态规划，数学
 * 题解：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
 */
public class No62_uniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; j++) {
                // 优化二：
                // cur[j] += cur[j-1],
                // 即cur[j] = cur[j] + cur[j-1]
                // 等价于思路二-->> cur[j] = pre[j] + cur[j-1]，
                // 因此空间复杂度为O(n).
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths_2(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];

        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; j++) {
                // 优化一：
                // 由于dp[i][j] = dp[i-1][j] + dp[i][j-1]
                // 因此只需要保留当前行与上一行的数据
                // (在动态方程中，即pre[j] = dp[i-1][j])，两行，
                // 空间复杂度O(2n)；
                cur[j] = pre[j] + cur[j - 1];
            }
            pre = cur.clone();
        }
        return cur[n - 1];
    }

    public int uniquePaths_3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths_combination(int m, int n) {
        if (n > m) {
            return C(m - 1, m + n - 2);
        }
        return C(n - 1, m + n - 2);
    }

    private int C(int m, int n) {
        int ans = 1;
        int j = 1;
        for (int i = 0; i < m; i++) {
            ans *= n - i;
            while (j <= m && ans % j == 0) {
                ans /= j;
                ++j;
            }
        }
        return ans;
    }
}
