package org.alphacat.leetcode.solution.easy.no1001to1100;

import java.util.LinkedList;
import java.util.List;

public class No1002 {

    private int[] alphabetCount;
    private int alphabetSize;

    public List<String> commonChars(String[] A) {
        initial();
        int n = A.length;
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            alphabetCount[getIndex(c)]++;
        }
        for (int i = 1; i < n; i++) {
            int[] tempAlphabetCount = new int[alphabetSize];
            String crrString = A[i];
            for (char c : crrString.toCharArray()) {
                tempAlphabetCount[getIndex(c)]++;
            }
            for (int j = 0; j < alphabetSize; j++) {
                alphabetCount[j] = Math.min(alphabetCount[j], tempAlphabetCount[j]);
            }
        }
        return outputList();
    }

    private List<String> outputList() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < alphabetSize; i++) {
            char c = getChar(i);
            for (int j = 0; j < alphabetCount[i]; j++) {
                list.add(String.valueOf(c));
            }
        }
        return list;
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    private char getChar(int i) {
        return (char) (i + 'a');
    }

    private void initial() {
        alphabetSize = 26;
        alphabetCount = new int[alphabetSize];
    }
}
