package org.alphacat.leetcode.solution.classic.binarysearch;

public class No287_findDuplicate {

    /**
     * https://leetcode-cn.com/problems/find-the-duplicate-number/
     * 287. 寻找重复数
     * ☆☆☆☆
     * 二分查找
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[fast];
        fast = nums[fast];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }

        int p = 0;
        while (p != fast) {
            p = nums[p];
            fast = nums[fast];
        }
        return p;
    }

    public int findDuplicate_binarySearch(int[] nums) {
        int n = nums.length;
        int l = 1;
        int h = n;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            int count = 0;

            for (int num : nums) {
                if (num <= mid) {
                    ++count;

                    if (count > mid) {
                        break;
                    }
                }
            }

            if (count <= mid) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
