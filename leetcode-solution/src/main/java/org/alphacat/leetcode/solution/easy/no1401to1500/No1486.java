package org.alphacat.leetcode.solution.easy.no1401to1500;

public class No1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            int temp = start + 2 * i;
            res ^= temp;
        }
        return res;
    }
}
