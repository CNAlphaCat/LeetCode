package org.alphacat.leetcode.solution.classic.sort;

public class No75_sortColors {

    // 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
    // 并按照红色、白色、蓝色顺序排列。

    // 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

    // https://leetcode-cn.com/problems/sort-colors/

    private int RED = 0;
    private int BLUE = 2;

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int current = 0;
        int p_red = 0;
        int p_blue = n - 1;
        while (current <= p_blue) {
            if (nums[current] == RED) {
                swap(nums, current, p_red);
                ++p_red;
                ++current;
                continue;
            }
            if (nums[current] == BLUE) {
                swap(nums, current, p_blue);
                --p_blue;
                continue;
            }
            ++current;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
