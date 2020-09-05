package org.alphacat.leetcode.solution.classic.arr.pointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List ans = new LinkedList();
        if (nums == null) {
            return ans;
        }
        int n = nums.length;
        if (n < 3) {
            return ans;
        }
        Arrays.sort(nums);

        int target = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                break;
            }
/*            if (i + 1 < n && nums[i] == nums[i + 1]) {
                continue;
            }*/

            // 与上面注释的写法不同，上面的是无法判断例如
            // [-1, 0, 1, 2, -1, -4]中的[-1, -1, 2]的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
