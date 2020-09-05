package org.alphacat.leetcode.solution.classic.arr.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 78. 子集
 * ☆☆☆☆
 * 子集，回溯
 */
public class No78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> nullList = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(nullList);

        for (int num : nums) {
            List<List<Integer>> tempList = new ArrayList<>();
            for (List<Integer> list : ans) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(num);
                tempList.add(copy);
            }
            for (List<Integer> item : tempList) {
                ans.add(item);
            }
        }
        return ans;
    }

    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        addSubset(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void addSubset(int begin, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; ++i) {
            temp.add(nums[i]);
            addSubset(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
