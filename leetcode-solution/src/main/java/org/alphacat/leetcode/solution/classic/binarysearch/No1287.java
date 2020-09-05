package org.alphacat.leetcode.solution.classic.binarysearch;


import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.LinkedList;
import java.util.List;

public class No1287 implements LeetCodeTest_1<int[], Integer> {

    private int NOT_FIND_RESULT_NUM = -1;

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int distance = n / 4 ;
        for (int i = 0; i < n; i += distance) {
            int left = lowerBound(arr, 0, n, arr[i]);
            int right = upperBound(arr, 0, n, arr[i]);
            if (right - left > distance) {
                return arr[i];
            }
        }

        return NOT_FIND_RESULT_NUM;
    }

    int lowerBound(int[] arr, int begin, int end, int target) {
        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int upperBound(int[] arr, int begin, int end, int target) {

        int low = begin;
        int high = end;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    //滑动窗口思想
    public int findSpecialInteger_2(int[] arr) {
        int n = arr.length;
        int windowsSize = n / 4;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i + windowsSize]) {
                return arr[i];
            }
        }
        return NOT_FIND_RESULT_NUM;
    }

    public int findSpecialInteger_3(int[] arr) {
        int n = arr.length;
        int lastNum = arr[0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int currentNum = arr[i];
            if (lastNum == currentNum) {
                count++;
                if (isBiggerThan25Percent(count, n)) {
                    return currentNum;
                }
                continue;
            }
            lastNum = arr[i];
            count = 1;
        }
        return NOT_FIND_RESULT_NUM;
    }

    private boolean isBiggerThan25Percent(int count, int n) {
        return count > n / 4;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new LinkedList<>();
        addToList(list, "[1,2,2,6,6,6,6,7,10]", "6");
        addToList(list, "[1]", "1");
        return list;
    }

    @Override
    public Integer testTask(int[] ints) {
        return findSpecialInteger(ints);
    }
}
