package org.alphacat.leetcode.solution.easy.no201to300;

public class No268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans ^= i;
        }
        for (int i = 0; i < n; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
