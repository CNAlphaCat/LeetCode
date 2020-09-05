package org.alphacat.leetcode.solution.classic.arr.pointer;

public class No11_maxArea {

    public int maxArea(int[] height) {
        int ans = 0;
        if (height == null) {
            return ans;
        }
        int n = height.length;
        if (n == 0) {
            return ans;
        }
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int tempArea = (r - l) * Math.min(height[l], height[r]);
            ans = Math.max(ans, tempArea);
            if (height[l] > height[r]) {
                --r;
            }
            else {
                ++l;
            }
        }
        return ans;
    }
}
