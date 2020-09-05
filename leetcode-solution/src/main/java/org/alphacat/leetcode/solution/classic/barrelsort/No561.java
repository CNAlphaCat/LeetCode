package org.alphacat.leetcode.solution.classic.barrelsort;


import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.ArrayList;
import java.util.List;

public class No561 implements LeetCodeTest_1<int[], Integer> {

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new ArrayList<>();
        addToList(list, "[1,4,3,2]", "4");
        return list;
    }

    @Override
    public Integer testTask(int[] ints) {
        return arrayPairSum(ints);
    }

    private int[] barrel;
    private int size;
    private int offset;

    public int arrayPairSum(int[] nums) {
        initial();
        for (int num : nums) {
            barrel[num + offset]++;
        }
        int num = 0;
        int sum = 0;
        int n = nums.length;
        int count = 0;
        while (num <= size && count < n) {
            num = findNextNum(num);
            barrel[num]--;
            sum += num - offset;
            num = findNextNum(num);
            barrel[num]--;
            count += 2;
        }
        return sum;
    }

    private int findNextNum(int index) {
        while (barrel[index] == 0) {
            index++;
        }
        return index;
    }

    private void initial() {
        offset = 10000;
        size = 20001;
        barrel = new int[size];
    }
}
