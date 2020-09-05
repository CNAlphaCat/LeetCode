package org.alphacat.leetcode.solution.classic.hash;

import java.util.HashSet;

public class No36_isValidSudoku {

    private int size = 9;
    private char DOT = '.';
    private int sizePreRow = 3;

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[size];
        HashSet<Character>[] column = new HashSet[size];
        HashSet<Character>[] area = new HashSet[size];
        for (int i = 0; i < size; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            area[i] = new HashSet<>();
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                char num = board[i][j];
                if (num == DOT) {
                    continue;
                }
                int areaId = (i / sizePreRow) * sizePreRow + j / sizePreRow;

                if (row[i].contains(num)) {
                    return false;
                } else {
                    row[i].add(num);
                }

                if (column[j].contains(num)) {
                    return false;
                } else {
                    column[j].add(num);
                }

                if (area[areaId].contains(num)) {
                    return false;
                } else {
                    area[areaId].add(num);
                }
            }
        }
        return true;
    }
}
