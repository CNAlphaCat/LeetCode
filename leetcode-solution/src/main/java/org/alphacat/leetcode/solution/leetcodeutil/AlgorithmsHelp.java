package org.alphacat.leetcode.solution.leetcodeutil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 287. 寻找重复数
 * ☆☆☆☆
 * 二分查找
 */
public class AlgorithmsHelp {

    private int getMax(int a, int b, int c) {
        int res = a;
        res = Math.max(res, b);
        res = Math.max(res, c);
        return res;
    }

    private int getMin(int a, int b, int c) {
        int res = a;
        res = Math.min(res, b);
        res = Math.min(res, c);
        return res;
    }

    private static int sizeOfInt(int x) {
        final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

    private List<Integer> intArrToList(int data[]) {
        IntStream is = Arrays.stream(data);
        Stream<Integer> s = is.boxed();
        List<Integer> res = s.collect(Collectors.toList());
        return res;
    }

    private int getSumByDigit(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp;
            n /= 10;
        }
        return sum;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
