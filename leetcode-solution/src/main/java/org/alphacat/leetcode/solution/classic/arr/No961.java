package org.alphacat.leetcode.solution.classic.arr;

public class No961 {

    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < A.length - k; i++) {
                if (A[i] == A[i + k]) {
                    return A[i];
                }
            }
        }
        return -1;
    }

    public int repeatedNTimes_2(int[] A) {
        int[] numCount = new int[10001];
        for (int num : A) {
            numCount[num]++;
            if (numCount[num] >= 2) {
                return num;
            }
        }
        return -1;
    }
}
