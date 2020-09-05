package org.alphacat.leetcode.solution.classic.arr;

public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; ++i) {
            L[i] = L[i - 1] * nums[i - 1];
            R[n - i - 1] = R[n - i] * nums[n - i];//对官方题解的一个优化，用不着遍历三次
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    //优化辅助空间至O(1)
    public int[] productExceptSelf_2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int r = 1;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
