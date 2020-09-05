package org.alphacat.leetcode.solution.mid.no1to1000;

public class No186 {

    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s,0,n-1);
        int j = 0;
        int i = 0;
        while (j < n) {
            while (j < n && s[j] != ' ') {
                ++j;
            }
            reverse(s, i, j - 1);
            i = j + 1;
            ++j;
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            ++i;
            --j;
        }
    }
}
