package org.alphacat.leetcode.solution.classic.maths;

import java.util.Arrays;

public class No204_countPrimes {

    private final int begin = 2;

    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = begin; i * i < n; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int ans = 0;

        for (int i = begin; i < n; ++i) {
            if (isPrime[i]) {
                ++ans;
            }
        }

        return ans;
    }

}
