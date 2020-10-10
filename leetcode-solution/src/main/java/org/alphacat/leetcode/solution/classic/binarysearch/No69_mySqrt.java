package org.alphacat.leetcode.solution.classic.binarysearch;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 69. x 的平方根
 * ☆☆☆☆
 * keyword:数学，二分查找，牛顿迭代
 */
public class No69_mySqrt {


    public int mySqrt(int x) {
        int l = 0;
        int h = x;

        int ans = 0;

        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            long square = (long) mid * mid;

            if (square > x) {
                h = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public int mySqrt_2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


}
