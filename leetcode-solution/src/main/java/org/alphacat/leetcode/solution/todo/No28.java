package org.alphacat.leetcode.solution.todo;


public class No28 {

    //使用Sunday算法

    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int n = haystack.length();
        if (m > n) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (isSubString(haystack, needle, i, n, m)) {
                return i;
            }
        }
        return -1;
    }

    boolean isSubString(String haystack, String needle, int p, int n, int m) {
        int i = p, j = 0;
        while (i < n && j < m) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        if (j == m && i <= n){
            return true;
        }
        return false;
    }
}
