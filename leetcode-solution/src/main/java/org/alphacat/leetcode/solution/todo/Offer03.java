package org.alphacat.leetcode.solution.todo;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        int len = nums == null ? 0 : nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
