package org.alphacat.leetcode.solution.classic.arr.merge;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 88. 合并两个有序数组
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给你两个有序整数数组 nums1 和 nums2，
 * 请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:数组
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No88_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            nums1[index++] = copy[i] < nums2[j] ? copy[i++] : nums2[j++];
        }
        if (i < m) {
            System.arraycopy(copy, i, nums1, index, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, index, n - j);
        }
    }
}
