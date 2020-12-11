package org.alphacat.leetcode.solution.classic.dp.binarysearch;

import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长上升子序列
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:二分查找
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No300_lengthOfLIS implements LeetCodeTest_1<int[], Integer> {

    private int ZERO = 0;

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return ZERO;
        }
        int n = nums.length;
        if (n == 0) {
            return ZERO;
        }
        int[] lis = new int[n];
        lis[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; ++i) {
            int num = nums[i];
            if (num > lis[end]) {
                ++end;
                lis[end] = num;
                continue;
            }
            int l = lower_bound(lis, 0, end, num);
            lis[l] = num;
        }
        return end + 1;
    }

    private int lower_bound(int[] nums, int begin, int end, int target) {
        int l = begin;
        int h = end + 1;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public int lengthOfLIS_dp(int[] nums) {
        if (nums == null) {
            return ZERO;
        }
        int n = nums.length;
        if (n == 0) {
            return ZERO;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int j = 1; j < n; ++j) {
            dp[j] = 1;
            for (int i = 0; i < j; ++i) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new LinkedList<>();
        addToList(list, "[4,10,4,3,8,9]", "3");
        return list;
    }

    @Override
    public Integer testTask(int[] ints) {
        return lengthOfLIS(ints);
    }
}
