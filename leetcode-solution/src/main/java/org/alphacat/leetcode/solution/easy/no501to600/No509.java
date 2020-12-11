package org.alphacat.leetcode.solution.easy.no501to600;

public class No509 {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int cur = 0;

        for (int i = 3; i <= N; i++) {
            cur = a + b;
            b = a;
            a = cur;
        }
        return cur;
    }
}
