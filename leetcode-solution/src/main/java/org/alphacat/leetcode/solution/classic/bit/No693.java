package org.alphacat.leetcode.solution.classic.bit;

public class No693 {

    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1);
        return (xor & (long) (xor + 1)) == 0;
    }
}
