package org.alphacat.leetcode.solution.classic.hash;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 128. 最长连续序列
 * ☆☆☆☆
 * 哈希表，数组
 */
public class No128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int count = 0;
            while (set.contains(currentNum)) {
                ++count;
                ++currentNum;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
