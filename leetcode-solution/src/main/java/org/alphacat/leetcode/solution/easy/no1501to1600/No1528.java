package org.alphacat.leetcode.solution.easy.no1501to1600;

public class No1528 {

    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            ans[indices[i]] = s.charAt(i);
        }
        return new String(ans);
    }
}
