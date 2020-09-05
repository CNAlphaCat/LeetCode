package org.alphacat.leetcode.solution.classic.maths.pow;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 50. Pow(x, n)
 * ☆☆☆☆
 * 数学，快速幂
 */
public class No50_pow {

    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    // 为什么要用long
    // 有以下用例
    // 2.00000
    // -2147483648

    private double quickPow(double x, long n) {
        double ans = 1.0;
        double y = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= y;
            }
            y *= y;
            n >>= 1;
        }
        return ans;
    }

    private double quickPow_recursive(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return ((n & 1) == 1) ? y * y * x : y * y;
    }
}
