package org.alphacat.leetcode.solution.classic.arr;

public class Interview17_04 {

    public int missingNumber(int[] nums) {
        int numsLength = nums.length;
        int xor = numsLength;
        for (int i = 0; i < numsLength; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
