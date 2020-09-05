package org.alphacat.leetcode.solution.easy.no901to1000;

public class No942 {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int max = n;
        int min = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            switch (c) {
                case 'I':
                    ans[i] = min;
                    min++;
                    break;
                case 'D':
                    ans[i] = max;
                    max--;
                    break;
            }
        }
        ans[n] = max;
        return ans;
    }
}
