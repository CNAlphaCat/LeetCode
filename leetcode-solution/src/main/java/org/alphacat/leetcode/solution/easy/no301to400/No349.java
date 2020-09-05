package org.alphacat.leetcode.solution.easy.no301to400;

import java.util.HashSet;

public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] ans = new int[intersectionSet.size()];
        int index = 0;
        for (Integer integer : intersectionSet) {
            ans[index++] = integer.intValue();
        }
        return ans;
    }
}
