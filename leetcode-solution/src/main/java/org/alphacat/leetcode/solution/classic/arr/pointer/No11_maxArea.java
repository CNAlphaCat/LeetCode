package org.alphacat.leetcode.solution.classic.arr.pointer;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:数组，双指针
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
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
