package org.alphacat.leetcode.solution.easy.no901to1000;

public class No922 {

    public int[] sortArrayByParityII(int[] A) {
        int evenIndex = 0;
        int oddIndex = 1;
        int n = A.length;
        while (evenIndex < n && oddIndex < n) {
            while (evenIndex < n && isEven(A[evenIndex])) {
                evenIndex += 2;
            }
            while (oddIndex < n && isOdd(A[oddIndex])) {
                oddIndex += 2;
            }
            if (evenIndex < n && oddIndex < n) {
                swap(A, evenIndex, oddIndex);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private boolean isEven(int n) {
        return !isOdd(n);
    }
}
