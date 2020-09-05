package org.alphacat.leetcode.solution.classic.arr;

import java.util.*;

public class No1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                ans[0] = map.get(target - num);
                ans[1] = i;
                break;
            }
            map.put(num,i);
        }
        return ans;
    }

    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                List<Integer> list = map.get(num);
                list.add(i);
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(num, list);
        }
        int[] ans = new int[2];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int num = entry.getKey();
            List<Integer> list = entry.getValue();
            if (num << 1 == target && list.size() > 1) {
                ans[0] = list.get(0);
                ans[1] = list.get(1);
                break;
            }
            if (map.containsKey(target - num)) {
                ans[0] = list.get(0);
                ans[1] = map.get(target - num).get(0);
            }
        }
        return ans;
    }

    public int[] twoSum_3(int[] nums, int target) {
        int[] arr = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}
