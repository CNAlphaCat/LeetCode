package org.alphacat.leetcode.solution.easy.no901to1000;

import java.util.Arrays;

public class No977 {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
