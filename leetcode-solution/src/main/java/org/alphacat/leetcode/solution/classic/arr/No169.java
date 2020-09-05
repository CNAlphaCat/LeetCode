package org.alphacat.leetcode.solution.classic.arr;

public class No169 {

    public int majorityElement(int[] nums) {
        int num = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (vote == 0) {
                num = nums[i];
            }
            if (nums[i] == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return num;
    }
}
