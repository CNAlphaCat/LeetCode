package org.alphacat.leetcode.solution.classic.dp;

import java.util.Arrays;

public class No322_coinChange {

    private int[] coins;

    private int[] count;

    private final int NOT_FOUND_NUM = -1;

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return NOT_FOUND_NUM;
        }
        initial(coins, amount);
        return coinChange(amount);
    }

    private int coinChange(int remains) {
        if (remains < 0) {
            return NOT_FOUND_NUM;
        }
        if (remains == 0) {
            return 0;
        }
        if (count[remains] != 0) {
            return count[remains];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChange(remains - coin);
            if (count >= 0 && count < min) {
                min = count + 1;
            }
        }
        count[remains] = min == Integer.MAX_VALUE ? NOT_FOUND_NUM : min;
        return count[remains];
    }

    private void initial(int[] coins, int amount) {
        this.coins = coins;
        count = new int[amount + 1];
    }


    public int coinChange_bottomToTop(int[] coins, int amount) {
        if (amount < 0) {
            return NOT_FOUND_NUM;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? NOT_FOUND_NUM : dp[amount];
    }
}
