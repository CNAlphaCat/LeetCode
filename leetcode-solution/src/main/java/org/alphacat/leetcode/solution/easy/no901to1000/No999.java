package org.alphacat.leetcode.solution.easy.no901to1000;

public class No999 {

    char[][] board;
    int n;

    public int numRookCaptures(char[][] board) {
        initial(board);
        Position position = getPosition();
        return findPawn(position.i, position.j);
    }

    private int findPawn(int i, int j) {
        int ans = 0;
        if (findPawn_Up(i - 1, j)) {
            ans++;
        }
        if (findPawn_Down(i + 1, j)) {
            ans++;
        }
        if (findPawn_Left(i, j - 1)) {
            ans++;
        }
        if (findPawn_Right(i, j + 1)) {
            ans++;
        }
        return ans;
    }

    private boolean isHaveAllies(int i, int j) {
        return board[i][j] == 'B';
    }

    private boolean isHavePawn(int i, int j) {
        return board[i][j] == 'p';
    }

    private boolean findPawn_Up(int i, int j) {
        for (int index = i; index >= 0; index--) {
            if (isHaveAllies(index, j)) {
                break;
            }
            if (isHavePawn(index, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean findPawn_Down(int i, int j) {
        for (int index = i; index < n; index++) {
            if (isHaveAllies(index, j)) {
                break;
            }
            if (isHavePawn(index, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean findPawn_Left(int i, int j) {
        for (int index = j; index >= 0; index--) {
            if (isHaveAllies(i, index)) {
                break;
            }
            if (isHavePawn(i, index)) {
                return true;
            }
        }
        return false;
    }

    private boolean findPawn_Right(int i, int j) {
        for (int index = j; index < n; index++) {
            if (isHaveAllies(i, index)) {
                break;
            }
            if (isHavePawn(i, index)) {
                return true;
            }
        }
        return false;
    }

    private class Position {
        int i;
        int j;

        public Position(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }

    private Position getPosition() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == 'R') {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private void initial(char[][] board) {
        this.board = board;
        this.n = 8;
    }
}
