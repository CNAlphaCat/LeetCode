package org.alphacat.leetcode.solution.easy.no1301to1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class No1365 {

    //双百解法，桶排序的思想，O(n)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int barrelSize = 101;//0 <= nums[i] <= 100
        int[] barrel = new int[barrelSize];
        int n = nums.length;
        for (int temp : nums) {
            barrel[temp]++;
        }
        for (int i = 1; i < barrelSize; i++) {
            barrel[i] += barrel[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            nums[i] = nums[i] > 0 ? barrel[temp - 1] : 0;
        }
        return nums;
    }

    //O(nlog n)，基于排序与排序数组的下标索引对应关系
    public int[] smallerNumbersThanCurrent_2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (map.containsKey(temp)) {
                LinkedList<Integer> tempSet = map.get(temp);
                tempSet.add(i);
                map.replace(temp, tempSet);
            } else {
                LinkedList tempSet = new LinkedList<Integer>();
                tempSet.add(i);
                map.put(temp, tempSet);
            }
        }
        int[] arrSorted = Arrays.copyOf(nums, n);
        Arrays.sort(arrSorted);
        int i = 0;
        while (i < n) {
            int temp = arrSorted[i];
            int lessThanNumCount = i;
            LinkedList<Integer> tempSet = map.get(temp);
            for (Integer index : tempSet) {
                nums[index] = lessThanNumCount;
                i++;
            }
        }
        return nums;
    }
}
