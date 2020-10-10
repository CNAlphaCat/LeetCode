package org.alphacat.leetcode.solution.classic.matrix.backtracking;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 * 37. 解数独
 * ☆☆☆☆
 * keyword:数组，回溯，数独
 * 题解：https://leetcode-cn.com/problems/sudoku-solver/solution/hui-su-fa-jie-shu-du-by-i_use_python/
 */
public class No37_solveSudoku {

    private final static char DOT = '.';
    private final static int SIZE = 9;
    private final static int AREA_COUNT = 81;
    private final static int EXIST_FLAG = 1;
    private final static int NOT_EXIST_FLAG = 0;

    private boolean[][] row;
    private boolean[][] col;
    private boolean[][] block;
    private char[][] board;
    private int count;
    private int m;
    private int n;

    public void solveSudoku(char[][] board) {
        init(board);
        solveSudoku(0, 0);
    }

    private boolean solveSudoku(int x, int y) {
        if (y == m) {
            y = 0;
            ++x;
        }
        if (x == n) {
            return true;
        }
        char c = board[x][y];
        if (c != DOT) {
            return solveSudoku(x, y + 1);
        }
        for (int num = 1; num <= SIZE; num++) {
            if (!isValid(x, y, num)) {
                continue;
            }
            row[x][num] = true;
            col[y][num] = true;
            block[getBlockIndex(x, y)][num] = true;
            board[x][y] = (char) (num + '0');

            if (solveSudoku(x, y + 1)) {
                return true;
            }

            row[x][num] = false;
            col[y][num] = false;
            block[getBlockIndex(x, y)][num] = false;
            board[x][y] = DOT;
        }
        return false;
    }

    private boolean isValid(int x, int y, int num) {
        return !row[x][num] && !col[y][num] && !block[getBlockIndex(x, y)][num];
    }

    private void init(char[][] board) {
        row = new boolean[SIZE][SIZE + 1];
        col = new boolean[SIZE][SIZE + 1];
        block = new boolean[SIZE][SIZE + 1];
        this.board = board;
        count = 0;
        m = board == null ? 0 : board.length;
        n = m == 0 ? 0 : board[0].length;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == DOT) {
                    continue;
                }
                int num = board[i][j] - '0';
                row[i][num] = true;
                col[j][num] = true;
                block[getBlockIndex(i, j)][num] = true;
                ++count;
            }
        }
    }

    private int getBlockIndex(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
