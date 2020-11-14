package org.alphacat.leetcode.solution.easy.no301to400;

public class No387 {

    private static final int ALPHABET_SIZE = 26;
    private static final int SINGLE_FIND_COUNT = 1;
    private static final int NOT_FIND_NUM = -1;

    public int firstUniqChar(String s) {
        int[] alphabetCount = new int[ALPHABET_SIZE];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ++alphabetCount[c - 'a'];
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alphabetCount[c - 'a'] == SINGLE_FIND_COUNT) {
                return i;
            }
        }
        return NOT_FIND_NUM;
    }
}
