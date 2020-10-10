package org.alphacat.leetcode.solution.mid.no1to1000;

public class No34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null) {
            return ans;
        }
        int n = nums.length;
        if (n == 0) {
            return ans;
        }
        int l = binarySearchLeft(nums, target);
        if (l == n || nums[l] != target) {
            return ans;
        }
        int r = binarySearchRight(nums, target);
        ans[0] = l;
        ans[1] = r;
        return ans;
    }

    private int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private int binarySearchRight(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (target < nums[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
