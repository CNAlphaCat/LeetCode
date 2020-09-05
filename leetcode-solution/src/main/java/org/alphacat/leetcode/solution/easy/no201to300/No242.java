package org.alphacat.leetcode.solution.easy.no201to300;

public class No242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int ALPHABET_SIZE = 26;
        char[] alphabet = new char[ALPHABET_SIZE];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabet[c - 'a']--;
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
