package org.alphacat.leetcode.solution.classic.bit;

public class No190 {
    // you need treat n as an unsigned value

    public int reverseBits(int n) {
        int intBitLength = 32;
        int res = 0;
        for (int i = 0; i < intBitLength; i++) {
            res <<= 1;//左移腾出最右一位
            res += (n & 1);//取n最右一位
            n >>= 1;
        }
        return res;
    }
}
