package org.alphacat.leetcode.solution.classic.arr.search;

public class No41_firstMissingPositive {

    /**
     * https://leetcode-cn.com/problems/first-missing-positive/
     * 41. 缺失的第一个正数
     * ☆☆☆☆
     * 数组
     * Hard
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; ++i) {
            int expectNum = i + 1;
            if (nums[i] != expectNum) {
                return expectNum;
            }
        }
        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
