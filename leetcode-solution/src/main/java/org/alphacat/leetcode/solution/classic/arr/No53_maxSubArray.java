package org.alphacat.leetcode.solution.classic.arr;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53. 最大子序和
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No53_maxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int crrSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            int temp = crrSum + nums[i];
            crrSum = Math.max(nums[i], temp);
            maxSum = Math.max(crrSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArray_divide(int[] nums) {
        Part part = getSum(nums, 0, nums.length - 1);
        return part.maxSubPartSum;
    }

    private Part getSum(int[] nums, int begin, int end) {
        if (begin == end) {
            return new Part(nums[begin], nums[begin], nums[begin], nums[begin]);
        }
        int mid = begin + ((end - begin) >> 1);
        Part l = getSum(nums, begin, mid);
        Part r = getSum(nums, mid + 1, end);
        return mergePart(l, r);
    }

    private Part mergePart(Part l, Part r) {
        int lSum = Math.max(l.lSum, l.totalSum + r.lSum);
        int rSum = Math.max(r.rSum, r.totalSum + l.rSum);
        int totalSum = l.totalSum + r.totalSum;
        int maxSubPartSum = Math.max(l.maxSubPartSum, r.maxSubPartSum);
        maxSubPartSum = Math.max(maxSubPartSum, l.rSum + r.lSum);
        return new Part(lSum, rSum, maxSubPartSum, totalSum);
    }

    private class Part {

        public int lSum;
        public int rSum;
        public int maxSubPartSum;
        public int totalSum;

        public Part(int lSum, int rSum, int maxSubPartSum, int totalSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.maxSubPartSum = maxSubPartSum;
            this.totalSum = totalSum;
        }
    }
}
