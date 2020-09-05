package org.alphacat.leetcode.solution.classic.comprehension;

public class No1332 {

    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
