package org.alphacat.leetcode.solution.easy.interview;

public class Interview01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int size = 52;
        int[] alphabet_s1 = new int[size];
        for (char c : s1.toCharArray()) {
            alphabet_s1[getIndex(c)]++;
        }
        int[] alphabet_s2 = new int[size];
        for (char c : s2.toCharArray()) {
            alphabet_s2[getIndex(c)]++;
        }
        for (int i = 0; i < size; i++) {
            if (alphabet_s1[i] != alphabet_s2[i]) {
                return false;
            }
        }
        return true;
    }

    private int getIndex(char c) {
        return c - 'a';
    }
}
