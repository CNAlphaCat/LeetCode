package org.alphacat.leetcode.solution.classic.arr;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 238. 除自身以外数组的乘积
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; ++i) {

            L[i] = L[i - 1] * nums[i - 1];

            //对官方题解的一个优化，用不着遍历三次
            R[n - i - 1] = R[n - i] * nums[n - i];
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
