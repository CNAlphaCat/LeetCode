package org.alphacat.leetcode.solution.classic.barrelsort;

import java.util.Arrays;

public class No1051 {

    public int heightChecker(int[] heights) {
        int maxSize = 101;
        int[] barrel = new int[maxSize];
        for (int h : heights) {
            barrel[h]++;
        }
        int ans = 0;
        int j = 0;
        for (int i = 1; i < maxSize; i++) {
            if (j == heights.length) {
                break;
            }
            while (barrel[i] > 0) {
                if (i != heights[j]) {
                    ans++;
                }
                j++;
                barrel[i]--;
            }
        }
        return ans;
    }

    public int heightChecker_2(int[] heights) {
        int n = heights.length;
        int[] copy = Arrays.copyOf(heights, n);
        Arrays.sort(copy);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != copy[i]) {
                ans++;
            }
        }
        return ans;
    }
}
