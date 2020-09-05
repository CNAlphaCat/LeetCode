package org.alphacat.leetcode.solution.classic.arr;

public class No1351 {

    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int j = n - 1;
        int sum = 0;
        for (int[] column : grid) {
            while (j >= 0 && column[j] < 0) {
                j--;
            }
            sum += n - j - 1;
        }
        return sum;
    }

    public int countNegatives_BinarySearch(int[][] grid) {
        int n = grid[0].length;
        int sum = 0;
        int l = 0;
        int h = n - 1;
        for (int[] column : grid) {
            while (l < h) {
                int mid = l + ((h - l) >> 1);
                if (column[mid] >= 0) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            if (column[l] < 0) {
                sum += n - l;
            }
            h = l;
            l = 0;
        }
        return sum;
    }

    public int countNegatives_BinarySearch_2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m > n) {
            return getSumWithLongerM(grid);
        }
        return getSumWithLongerN(grid);
    }

    private int getSumWithLongerM(int[][] grid) {
        int m = grid[0].length;
        int sum = 0;
        int l = 0;
        int h = m - 1;
        for (int[] row : grid) {
            while (l < h) {
                int mid = l + ((h - l) >> 1);
                if (row[mid] >= 0) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            if (row[l] < 0) {
                sum += m - l;
            }
            h = l;
            l = 0;
        }
        return sum;
    }

    private int getSumWithLongerN(int[][] grid) {
        int n = grid[0].length;
        int sum = 0;
        int l = 0;
        int h = n - 1;
        for (int[] column : grid) {
            while (l < h) {
                int mid = l + ((h - l) >> 1);
                if (column[mid] >= 0) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            if (column[l] < 0) {
                sum += n - l;
            }
            h = l;
            l = 0;
        }
        return sum;
    }
}
