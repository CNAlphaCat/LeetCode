package org.alphacat.leetcode.solution.classic.arr.permutation;

public class No31_nextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            --i;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
