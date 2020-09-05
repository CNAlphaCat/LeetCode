package org.alphacat.leetcode.solution.easy.no901to1000;

public class No905 {

    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int h = A.length - 1;
        while (l < h) {
            while (l < h && isEven(A[l])) {
                l++;
            }
            while (l < h && isOdd(A[h])) {
                h--;
            }
            swap(A, l, h);
        }
        return A;
    }

    private boolean isEven(int n) {
        return !isOdd(n);
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
