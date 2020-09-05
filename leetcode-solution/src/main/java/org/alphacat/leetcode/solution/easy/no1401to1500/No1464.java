package org.alphacat.leetcode.solution.easy.no1401to1500;

import java.util.PriorityQueue;

public class No1464 {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(2);
        queue.add(nums[0]);
        queue.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = nums[i];
            if (temp > queue.peek()) {
                queue.poll();
                queue.add(temp);
            }
        }
        return (queue.poll() - 1) * (queue.poll() - 1);
    }
}
