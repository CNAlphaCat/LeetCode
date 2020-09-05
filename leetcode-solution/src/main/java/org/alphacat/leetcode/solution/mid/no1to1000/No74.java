package org.alphacat.leetcode.solution.mid.no1to1000;

public class No74 {

    private int NOT_FOUND_NUM = -1;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int row = max_bound(matrix, 0, target);
        if (row == NOT_FOUND_NUM) {
            return false;
        }
        int column = lower_bound(matrix[row], target);
        if (column == n) {
            return false;
        }
        return matrix[row][column] == target;
    }

    private int max_bound(int[][] matrix, int column, int target) {
        int m = matrix.length;
        int l = 0;
        int h = m - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if (matrix[mid][column] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    private int lower_bound(int[] arr, int target) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
