package org.alphacat.leetcode.solution.classic.binarysearch;

public class No153_findMin {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[h];
    }

    public int findMin_2(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }

        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (nums[0] > nums[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
