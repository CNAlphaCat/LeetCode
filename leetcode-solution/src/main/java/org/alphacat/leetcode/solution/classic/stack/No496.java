package org.alphacat.leetcode.solution.classic.stack;

import java.util.HashMap;
import java.util.Stack;

public class No496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }
        int n = nums1.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums1[i])) {
                ans[i] = map.get(nums1[i]);
                continue;
            }
            ans[i] = -1;
        }
        return ans;
    }
}
