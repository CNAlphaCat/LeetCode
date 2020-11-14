package org.alphacat.leetcode.solution.classic.dp.array;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 * 375. 猜数字大小 II
 * keyword:dp
 * 题解：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/dong-tai-gui-hua-c-you-tu-jie-by-zhang-xiao-tong-2/
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 *
 * 一开始的思路：直接模拟二分查找，统计所查找过的数字的值
 *
 * 实际上这是不对的：为什么不对？
 *
 * 因为二分查找只能保证这是一种宏观上对数级别的查找方法，但这不是一种对这个问题来说，每一步都是最优解的方法
 *
 * 比如在[1,2]这个区间上，对于二分查找来说，先猜1还是先猜2我们假定是没有代价的
 *
 * 但是实际上对于这个问题来说，先猜1才能得到最优解，因为代价是1，如果先猜2，那么代价是2
 *
 * 因此这个问题需要用dp来穷举
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No375_getMoneyAmount {

    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = 0;
        }

        for (int j = 2; j < n + 1; j++) {
            for (int i = j - 1; i >= 1; i--) {
                for (int k = i + 1; k <= j - 1; k++) {
                    int maxPart = Math.max(dp[i][k - 1], dp[k + 1][j]);
                    dp[i][j] = Math.min(k + maxPart, dp[i][j]);
                }
                dp[i][j] = Math.min(i + dp[i + 1][j], dp[i][j]);
                dp[i][j] = Math.min(dp[i][j], j + dp[i][j - 1]);
            }
        }

        return dp[1][n];
    }
}
