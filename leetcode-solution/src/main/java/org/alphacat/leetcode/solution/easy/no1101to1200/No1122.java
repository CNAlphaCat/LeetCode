package org.alphacat.leetcode.solution.easy.no1101to1200;



import org.alphacat.test.framework.leetcodetest.LeetCodeTest_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1122 implements LeetCodeTest_2<int[], int[], int[]> {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int range = 1001;
        int[] numsCount = new int[range];
        for (int num : arr1) {
            numsCount[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            int count = numsCount[num];
            for (int i = 0; i < count; i++) {
                arr1[index++] = num;
            }
            numsCount[num] = 0;
        }
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < numsCount[i]; j++) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }


    public int[] relativeSortArray_2(int[] arr1, int[] arr2) {
        int arr1_length = arr1.length;
        int l = 0;
        for (int num : arr2) {
            int h = arr1_length - 1;
            while (l < h) {
                while (l < h && arr1[h] != num) {
                    h--;
                }
                swap(arr1, l, h);
                if (arr1[l] == num) {
                    l++;
                }
            }
        }
        Arrays.sort(arr1, l, arr1_length);
        return arr1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();
        addToList(list, "[26,21,11,20,50,34,1,18]", "[21,11,26,20]", "[21,11,26,20,1,18,34,50]");
        addToList(list, "[2,3,1,3,2,4,6,7,9,2,19]", "[2,1,4,3,9,6]", "[2,2,2,1,4,3,3,9,6,7,19]");
        return list;
    }

    @Override
    public int[] testTask(int[] ints, int[] ints2) {
        return relativeSortArray(ints, ints2);
    }
}
