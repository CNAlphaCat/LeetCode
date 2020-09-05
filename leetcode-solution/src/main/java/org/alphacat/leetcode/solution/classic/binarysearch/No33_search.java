package org.alphacat.leetcode.solution.classic.binarysearch;


import org.alphacat.test.framework.leetcodetest.LeetCodeTest_2;

import java.util.ArrayList;
import java.util.List;

public class No33_search implements LeetCodeTest_2<int[], Integer, Integer> {

    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array
    public int search(int[] nums, int target) {
        int NOT_FOUND_NUM = -1;
        if (nums == null) {
            return NOT_FOUND_NUM;
        }
        int n = nums.length;
        if (n == 0) {
            return NOT_FOUND_NUM;
        }

        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
                continue;
            }
            if (nums[mid] < target && target <= nums[n - 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return NOT_FOUND_NUM;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();

        addToList(list, "[4,5,6,7,8,9,1,2,3]", "1", "6");

        addToList(list, "[4,5,6,7,0,1,2]", "0", "4");
        addToList(list, "[4,5,6,7,0,1,2]", "3", "-1");

        return list;
    }

    @Override
    public Integer testTask(int[] ints, Integer integer) {
        return search(ints, integer);
    }
}
