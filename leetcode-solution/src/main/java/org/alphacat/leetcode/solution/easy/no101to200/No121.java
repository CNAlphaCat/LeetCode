package org.alphacat.leetcode.solution.easy.no101to200;

public class No121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int low = prices[0];
        int high = prices[0];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            } else if (prices[i] > high) {
                high = prices[i];
            }
            sum = Math.max(high - low, sum);
        }
        return sum;
    }
}
