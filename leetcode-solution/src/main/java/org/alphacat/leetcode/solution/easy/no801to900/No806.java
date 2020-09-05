package org.alphacat.leetcode.solution.easy.no801to900;

public class No806 {

    public int[] numberOfLines(int[] widths, String S) {
        int row = 1;
        int rowLetters = 0;
        for (char letter : S.toCharArray()) {
            int width = widths[getIndex(letter)];
            rowLetters += width;
            if (rowLetters > 100) {
                row++;
                rowLetters = width;
            }
        }
        int[] ans = new int[2];
        ans[0] = row;
        ans[1] = rowLetters;
        return ans;
    }

    private int getIndex(char c) {
        return c - 'a';
    }
}
