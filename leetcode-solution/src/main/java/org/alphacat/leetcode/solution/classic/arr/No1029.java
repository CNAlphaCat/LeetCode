package org.alphacat.leetcode.solution.classic.arr;


import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No1029 implements LeetCodeTest_1<int[][], Integer> {

    private final int GOTO_A_PEOPLE = 0;
    private final int GOTO_B_PEOPLE = 1;

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int sum = 0;
        int[] differOfCosts = new int[n];
        for (int i = 0; i < n; i++) {
            differOfCosts[i] = costs[i][GOTO_B_PEOPLE] - costs[i][GOTO_A_PEOPLE];
            sum += costs[i][GOTO_A_PEOPLE];//假设所有人都去A市
        }
        quickSort(differOfCosts, 0, n - 1);
        for (int i = 0; i < n / 2; i++) {
            sum += differOfCosts[i];
        }
        return sum;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partIndex = quickSortOneTurn(arr, low, high);
        quickSort(arr, low, partIndex - 1);
        quickSort(arr, partIndex + 1, high);
    }

    private int quickSortOneTurn(int[] arr, int low, int high) {
        int baseNum = arr[low];
        while (low < high) {
            while (low < high && baseNum < arr[high]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && baseNum >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = baseNum;
        return low;
    }

    public int twoCitySchedCost_2(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs, (o1, o2) -> {
            return o2[GOTO_A_PEOPLE] - o2[GOTO_B_PEOPLE]
                    - (o1[GOTO_A_PEOPLE] - o1[GOTO_B_PEOPLE]);
        });
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += costs[i][GOTO_B_PEOPLE] + costs[i + n / 2][GOTO_A_PEOPLE];
        }
        return sum;
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new LinkedList<>();
        addToList(list, "[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]", "1");
        return list;
    }

    @Override
    public Integer testTask(int[][] ints) {
        return twoCitySchedCost(ints);
    }
}
