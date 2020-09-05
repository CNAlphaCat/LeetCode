package org.alphacat.leetcode.solution.easy.no1301to1400;

public class No1313 {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        int[] res = new int[sum];
        int index = 0;
        for (int i = 0; i < n; i += 2) {
            int count = nums[i];
            int tempCount = 0;
            while (tempCount < count) {
                res[index] = nums[i + 1];
                index++;
                tempCount++;
            }
        }
        return res;
    }
}
