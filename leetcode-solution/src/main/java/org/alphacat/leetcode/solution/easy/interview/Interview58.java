package org.alphacat.leetcode.solution.easy.interview;

public class Interview58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String reverseLeftWords_2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            char temp = s.charAt(i);
            sb.append(temp);
        }
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            sb.append(temp);
        }
        return sb.toString();
    }
}
