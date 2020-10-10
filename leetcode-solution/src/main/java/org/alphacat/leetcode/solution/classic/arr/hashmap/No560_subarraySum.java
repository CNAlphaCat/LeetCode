package org.alphacat.leetcode.solution.classic.arr.hashmap;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为K的子数组
 * ☆☆☆☆
 * keyword:数组，哈希表，子数组求和
 */
public class No560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(len);
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
