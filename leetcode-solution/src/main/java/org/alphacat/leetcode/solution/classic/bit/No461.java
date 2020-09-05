package org.alphacat.leetcode.solution.classic.bit;

public class No461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int sum = 0;
        while (xor != 0) {
            sum++;
            xor &= (xor - 1);
        }
        return sum;
    }

    public int hammingDistance_2(int x, int y) {
        int xor = x ^ y;
        int sum = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                sum++;
            }
            xor >>= 1;
        }
        return sum;
    }
}
