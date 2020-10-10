package org.alphacat.leetcode.solution.classic.arr.search;

/**
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 * 419. 甲板上的战舰
 * ☆☆☆☆
 * keyword: 图
 * 题解：https://leetcode-cn.com/problems/battleships-in-a-board/solution/q419-battleships-in-a-board-by-ronhou/
 */
public class No419_countBattleships {

    private final static char BATTLE_SHIP = 'X';

    public int countBattleships(char[][] board) {
        int res = 0;
        if (board == null) {
            return res;
        }
        int m = board.length;
        if (m == 0) {
            return res;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != BATTLE_SHIP) {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == BATTLE_SHIP) {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == BATTLE_SHIP) {
                    continue;
                }
                ++res;
            }
        }
        return res;
    }
}
