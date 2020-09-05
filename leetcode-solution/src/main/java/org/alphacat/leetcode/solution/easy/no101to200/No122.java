package org.alphacat.leetcode.solution.easy.no101to200;

public class No122 {

    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i];
            if (currentPrice > high) {
                high = currentPrice;
                continue;
            }
            if (high > low) {
                sum += high - low;
                low = currentPrice;
                high = currentPrice;
                continue;
            }
            low = currentPrice;
            high = currentPrice;
        }
        sum += high - low;
        return sum;
    }

    public int maxProfit_2(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
