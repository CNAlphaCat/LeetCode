package org.alphacat.leetcode.solution.classic.arr;

public class No303 {


    class NumArray {

        private int[] sum;
        private int n;

        public NumArray(int[] nums) {
            if (nums == null) {
                return;
            }
            n = nums.length;
            sum = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                sum[i] += nums[i - 1] + sum[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    //超出内存限制
    class NumArray_2 {

        private int[][] dp;

        public NumArray_2(int[] nums) {
            int n = nums.length;
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[j][j];
                }
            }
        }

        public int sumRange(int i, int j) {
            return dp[i][j];
        }
    }
}
