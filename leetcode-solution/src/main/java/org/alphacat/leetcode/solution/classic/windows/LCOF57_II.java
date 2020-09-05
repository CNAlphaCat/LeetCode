package org.alphacat.leetcode.solution.classic.windows;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LCOF57_II {

    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][];
        }
        int i = 1;
        int j = 2;
        int sum = i + j;
        List<int[]> list = new LinkedList<>();
        while (i<j) {
            if (sum < target) {
                j++;
                sum += j;
                continue;
            } else if (sum > target) {
                sum -= i;
                i++;
                continue;
            }
            int[] ints = getInt(i, j);
            list.add(ints);
            sum -= i;
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    private int[] getInt(int begin, int end) {
        int n = end - begin + 1;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = begin + i;
        }
        return ints;
    }

    public int[][] findContinuousSequence_2(int target) {
        if (target < 3) {
            return new int[0][];
        }
        int i = 0;
        int j = 1;

        int maxNum = target / 2 + 1;
        int[] arr = getOriginalInt(maxNum);
        int sum = arr[i] + arr[j];
        List<int[]> list = new LinkedList<>();
        while (i<j) {
            if (sum < target) {
                j++;
                sum += arr[j];
                continue;
            } else if (sum > target) {
                sum -= arr[i];
                i++;
                continue;
            }
            int[] tempArr = Arrays.copyOfRange(arr, i, j + 1);
            list.add(tempArr);
            sum -= arr[i];
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    private int[] getOriginalInt(int n) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }
}
