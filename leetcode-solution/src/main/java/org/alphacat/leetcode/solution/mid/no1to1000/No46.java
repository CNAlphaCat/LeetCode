package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    private List<List<Integer>> ans;
    private int[] nums;
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        initial(nums);
        permute(0);
        return ans;
    }

    private void permute(int begin) {
        if (begin == n - 1) {
            List<Integer> temp = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }
        for (int i = begin; i < n; ++i) {
            swap(nums, begin, i);
            permute(begin + 1);
            swap(nums, begin, i);
        }
    }

    private void initial(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        int size = 1;
        for (int i = 1; i <= n; ++i) {
            size *= i;
        }
        ans = new ArrayList<>(size);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
