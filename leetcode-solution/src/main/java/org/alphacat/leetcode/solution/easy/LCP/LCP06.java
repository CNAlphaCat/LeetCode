package org.alphacat.leetcode.solution.easy.LCP;

public class LCP06 {
    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int coinNum = coins[i];
            for (int j = coinNum; j > 0; j -= 2) {
                count++;
            }
        }
        return count;
    }
}
