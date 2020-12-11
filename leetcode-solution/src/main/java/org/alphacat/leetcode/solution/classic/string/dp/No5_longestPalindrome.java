package org.alphacat.leetcode.solution.classic.string.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No5_longestPalindrome {

    private String s;
    private int n;

    public String longestPalindrome(String s) {
        n = s.length();
        this.s = s;
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLength = 1;
        String ans = s.substring(0, 1);
        for (int i = 0; i < n - 1; i++) {
            String s_odd = centerSpread(chars, i, i);
            String s_even = centerSpread(chars, i, i + 1);
            if (s_even.length() > maxLength) {
                ans = s_even;
                maxLength = s_even.length();
            }
            if (s_odd.length() > maxLength) {
                ans = s_odd;
                maxLength = s_odd.length();
            }
        }
        return ans;
    }


    private String centerSpread(char[] chars, int centerLeft, int centerRight) {
        int i = centerLeft;
        int j = centerRight;
        while (i >= 0 && j < n) {
            if (chars[i] != chars[j]) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome_dp(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int begin = 0;

        // 如果取0，"ab"就只会返回空字符串
        int maxLength = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    continue;
                }

                //以下为chars[i] == chars[j]的情况

                if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                int currentLength = j - i + 1;
                if (dp[i][j] && currentLength > maxLength) {
                    begin = i;
                    maxLength = currentLength;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public String longestPalindrome_Force(String s) {
        String res = "", temp;
        int l = s.length();
        int max = 0;
        int tempL = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j <= l; j++) {
                temp = s.substring(i, j);
                tempL = temp.length();
                if (isPalindrome(temp) && tempL > max) {
                    max = tempL;
                    res = temp;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_recursion(String s, int i, int j) {
        if (j - i <= 0){
            return true;
        }
        if (s.charAt(i) != s.charAt(j)){
            return false;
        }
        return isPalindrome_recursion(s, i + 1, j - 1);
    }


}
