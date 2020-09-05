package org.alphacat.leetcode.solution.classic.binarysearch;

public class No1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int max = 0;
        for (int item : bloomDay) {
            max = Math.max(max, item);
        }
        int min = 0;
        int res = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (isEnough(bloomDay, k, mid, m)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    //二分法中取坐闭右开区间
    public int minDays_2(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int max = 0;
        for (int item : bloomDay) {
            max = Math.max(max, item);
        }
        int min = 0;
        int res = -1;
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (isEnough(bloomDay, k, mid, m)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean isEnough(int[] bloomDay, int k, int max, int m) {
        int count = getCount(bloomDay, k, max);
        return count >= m;
    }

    private int getCount(int[] bloomDay, int k, int max) {
        int res = 0;
        int tempCount = 0;
        for (int day : bloomDay) {
            if (day <= max) {
                tempCount++;
            } else {
                tempCount = 0;
            }
            if (tempCount == k) {
                res++;
                tempCount = 0;
            }
        }
        return res;
    }
}
