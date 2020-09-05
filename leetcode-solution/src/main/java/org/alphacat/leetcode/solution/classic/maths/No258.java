package org.alphacat.leetcode.solution.classic.maths;

public class No258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
