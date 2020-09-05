package org.alphacat.leetcode.solution.mid.no1to1000;

public class No348 {
    class TicTacToe {
        int [] horizontalArrCount;
        int [] verticalArrCount;
        int [] diagonalArrCount;
        int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            horizontalArrCount=new int[n];
            verticalArrCount=new int[n];
            diagonalArrCount=new int[2];
            this.n=n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int count=getCountByPlayer(player);
            horizontalArrCount[col]+=count;
            if(horizontalArrCount[col]==n || horizontalArrCount[col]==-n){
                return player;
            }
            verticalArrCount[row]+=count;
            if(verticalArrCount[row]==n || verticalArrCount[row]==-n){
                return player;
            }
            if(row==col){
                diagonalArrCount[0]+=count;
                if(diagonalArrCount[0]==n || diagonalArrCount[0]==-n){
                    return player;
                }
            }
            if(row==n-col-1){
                diagonalArrCount[1]+=count;
                if(diagonalArrCount[1]==n || diagonalArrCount[1]==-n){
                    return player;
                }
            }
            return 0;
        }

        private int getCountByPlayer(int player){
            if(player==1) return 1;
            return -1;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
