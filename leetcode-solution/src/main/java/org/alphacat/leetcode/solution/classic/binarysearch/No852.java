package org.alphacat.leetcode.solution.classic.binarysearch;

public class No852 {

    public int peakIndexInMountainArray(int[] A) {
        int n = A.length;
        int l = 1;
        int h = n - 1;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (A[mid - 1] < A[mid]) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return l;
    }

}
