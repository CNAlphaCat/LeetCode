package org.alphacat.leetcode.solution.classic.windows;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 239. 滑动窗口最大值
 * ☆☆☆☆
 * keyword:滑动窗口，双端队列
 */
public class No239_maxSlidingWindow {

    private Deque<Integer> deque;
    private int[] nums;
    private int k;
    private int n;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        init(nums, k);
        if (n == 0) {
            return new int[0];
        }
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            cleanDeque(i);
            deque.addLast(i);
        }
        ans[0] = nums[deque.getFirst()];
        for (int i = k; i < n; i++) {
            cleanDeque(i);
            deque.addLast(i);
            ans[i - k + 1] = nums[deque.getFirst()];
        }
        return ans;
    }

    private void init(int[] _nums, int _k) {
        this.nums = _nums;
        deque = new ArrayDeque<>();
        this.k = _k;
        n = _nums.length;
    }

    private void cleanDeque(int i) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow_2(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; ++i) {
            ans[i] = Math.max(left[i + k - 1], right[i]);
        }
        return ans;
    }

}
