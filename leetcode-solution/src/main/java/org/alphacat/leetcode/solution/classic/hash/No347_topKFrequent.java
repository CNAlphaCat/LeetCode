package org.alphacat.leetcode.solution.classic.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 * ☆☆☆☆
 * keyword:topK，哈希表，堆
 * 题解：
 */
public class No347_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> bigHeap =
                new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bigHeap.add(entry);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; ++i) {
            Map.Entry<Integer, Integer> entry = bigHeap.poll();
            ans[i] = entry.getKey();
        }
        return ans;
    }
}
