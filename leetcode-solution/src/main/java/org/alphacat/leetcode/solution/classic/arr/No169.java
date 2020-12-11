package org.alphacat.leetcode.solution.classic.arr;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 169. 多数元素
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
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
