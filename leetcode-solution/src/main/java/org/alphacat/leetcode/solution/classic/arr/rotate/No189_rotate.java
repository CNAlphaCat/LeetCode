package org.alphacat.leetcode.solution.classic.arr.rotate;


public class No189_rotate {

    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k %= n;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            swap(arr, begin, end);
            ++begin;
            --end;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void rotate_2(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k %= n;
        int count = 0;
        int begin = 0;
        while (count < n) {
            int pre = nums[begin];
            int index = begin;
            do {
                int next = (index + k) % n;
                int nextNum = nums[next];
                nums[next] = pre;
                pre = nextNum;
                index = next;
                ++count;
            } while (index != begin);
            ++begin;
        }
    }
}
