package org.alphacat.leetcode.solution.classic.maths.pow;

public class No70_climbStairs {

    public int climbStairs(int n) {
        return pow(n)[0][0];
    }

    private int[][] pow(int n) {
        int[][] multiplier = {{1, 1}, {1, 0}};
        int[][] ans = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = multiply(ans, multiplier);
            }
            n >>= 1;
            multiplier = multiply(multiplier, multiplier);
        }
        return ans;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    public int climbStairs_3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

    public int climbStairs_2(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    private int[] steps;

    public int climbStairs_fib(int n) {
        if (n == 1) {
            return 1;
        }
        steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        return fib(n);
    }

    private int fib(int n) {
        if (steps[n] > 0) {
            return steps[n];
        }
        steps[n] = fib(n - 1) + fib(n - 2);
        return steps[n];
    }
}
