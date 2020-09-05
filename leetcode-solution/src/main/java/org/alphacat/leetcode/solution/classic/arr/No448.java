package org.alphacat.leetcode.solution.classic.arr;

import java.util.ArrayList;
import java.util.List;

public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
