package org.alphacat.leetcode.solution.classic.sort.quicksort;


import org.alphacat.test.framework.leetcodetest.LeetCodeTest_2;

import java.util.ArrayList;
import java.util.List;

public class No215_findKthLargest implements LeetCodeTest_2<int[], Integer, Integer> {

    private int k;

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        inti(k, n);
        return quickSelect(nums, 0, n - 1);
    }

    private void inti(int k, int length) {
        this.k = length - k;
    }

    private int quickSelect(int[] nums, int begin, int end) {
        int part = partition(nums, begin, end);
        if (part == k) {
            return nums[part];
        } else if (part > k) {
            return quickSelect(nums, begin, part - 1);
        }
        return quickSelect(nums, part + 1, end);
    }

    private int partition(int[] nums, int begin, int end) {

        if (end - begin >= 2) {
            baseDeal(nums, begin, end);
            ++begin;
            --end;
        }

        int base = nums[begin];
        int j = begin;
        for (int i = begin + 1; i <= end; ++i) {
            if (base > nums[i]) {
                ++j;
                swap(nums, i, j);
            }
        }
        swap(nums, begin, j);
        return j;
    }

    private void baseDeal(int[] nums, int begin, int end) {
        int mid = begin + ((end - begin) >> 1);
        if (nums[begin] > nums[mid]) {
            swap(nums, begin, mid);
        }
        if (nums[begin] > nums[end]) {
            swap(nums, begin, end);
        }
        if (nums[mid] > nums[end]) {
            swap(nums, mid, end);
        }
        swap(nums, begin + 1, mid);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();
        addToList(list, "[3,2,3,1,2,4,5,5,6]", "4", "4");

        addToList(list, "[3,2,1,5,6,4]", "2", "5");
        return list;
    }

    @Override
    public Integer testTask(int[] ints, Integer integer) {
        return findKthLargest(ints, integer);
    }
}
