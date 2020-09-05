package org.alphacat.leetcode.solution.easy.no1401to1500;

public class No1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index++] = nums[i];
            res[index++] = nums[n + i];
        }
        return res;
    }
}
