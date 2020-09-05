package org.alphacat.leetcode.solution.easy.LCP;

public class LCP01 {
    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                res++;
            }
        }
        return res;
    }
}
