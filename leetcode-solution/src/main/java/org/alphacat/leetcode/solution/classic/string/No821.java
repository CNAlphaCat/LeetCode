package org.alphacat.leetcode.solution.classic.string;

public class No821 {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] ans = new int[n];
        int indexOfC = -n;
        char[] chars = S.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == C) {
                indexOfC = i;
            }
            ans[i] = i - indexOfC;
        }
        indexOfC = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == C) {
                indexOfC = i;
            }
            ans[i] = Math.min(indexOfC - i, ans[i]);
        }
        return ans;
    }
}
