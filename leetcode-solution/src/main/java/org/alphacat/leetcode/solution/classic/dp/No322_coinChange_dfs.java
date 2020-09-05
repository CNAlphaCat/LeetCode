package org.alphacat.leetcode.solution.classic.dp;

import java.util.Arrays;

public class No322_coinChange_dfs {

    private final int NOT_FOUND_NUM = -1;

    private int[] coins;
    private int ans;
    private int n;

    public int coinChange(int[] coins, int amount) {
        initial(coins, amount);
        dfs(n - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? NOT_FOUND_NUM : ans;
    }

    private void initial(int[] coins, int amount) {
        this.coins = coins;
        Arrays.sort(this.coins);
        ans = Integer.MAX_VALUE;
        n = coins.length;
    }

    private void dfs(int index, int amount, int count) {
        if (index < 0) {
            return;
        }
        int coin = coins[index];
        for (int i = amount / coin; i >= 0; --i) {
            int remains = amount - i * coin;
            int coinCount = count + i;
            if (remains == 0) {
                ans = Math.min(ans, coinCount);
                break;
            }
            if (coinCount + 1 >= ans) {
                break;
            }
            dfs(index - 1, remains, coinCount);
        }
    }
}
