package org.alphacat.leetcode.solution.easy.no501to600;

public class No509 {

    public int fib(int N) {
        int[] fib = new int[31];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[N];
    }
}
