package org.alphacat.leetcode.solution.classic.arr;

public class No283 {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int lastNotZero = 0;
        int pointer = 0;
        while (pointer < n) {
            if (nums[pointer] != 0) {
                swap(nums, pointer, lastNotZero);
                lastNotZero++;
            }
            pointer++;
        }
    }

    public void moveZeroes_2(int[] nums) {
        int n = nums.length;
        int lastNotZero = 0;
        int pointer = 0;
        while (pointer < n) {
            if (nums[pointer] != 0) {
                nums[lastNotZero] = nums[pointer];
                lastNotZero++;
            }
            pointer++;
        }
        while (lastNotZero < n) {
            nums[lastNotZero++] = 0;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
