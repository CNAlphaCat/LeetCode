package org.alphacat.leetcode.solution.classic.arr.pointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 15. 三数之和
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No15_threeSum {

    private final static int TARGET = 0;

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

        for (int i = 0; i < n; i++) {
            if (nums[i] > TARGET) {
                break;
            }
            /*
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                continue;
            }
            */

            // 与上面注释的写法不同，上面的是无法判断例如
            // [-1, 0, 1, 2, -1, -4]中的[-1, -1, 2]的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == TARGET) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > TARGET) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
