package org.alphacat.leetcode.solution.easy.no101to200;

public class No125 {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int h = n - 1;
        while (l < h) {
            char c1 = s.charAt(l);
            while (l < h && !isLetter(c1)) {
                ++l;
                c1 = s.charAt(l);
            }
            char c2 = s.charAt(h);
            while (l < h && !isLetter(c2)) {
                --h;
                c2 = s.charAt(h);
            }
            if (!isEqual(c1, c2)) {
                return false;
            }
            ++l;
            --h;
        }
        return true;
    }

    private boolean isEqual(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    private boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
