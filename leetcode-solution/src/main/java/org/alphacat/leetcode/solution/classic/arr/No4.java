package org.alphacat.leetcode.solution.classic.arr;

public class No4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1 != null ? nums1.length : 0;
        int l2 = nums2 != null ? nums2.length : 0;
        int mid1 = (l1 + l2 + 1) / 2;
        int mid2 = (l1 + l2 + 2) / 2;
        return (findK(nums1, 0, l1 - 1, nums2, 0, l2 - 1, mid1) + findK(nums1, 0, l1 - 1, nums2, 0, l2 - 1, mid2)) * 0.5;
    }

    public int findK(int[] nums1, int b1, int e1, int[] nums2, int b2, int e2, int k) {
        int l1 = e1 - b1 + 1;
        int l2 = e2 - b2 + 1;
        if (l1 > l2) return findK(nums2, b2, e2, nums1, b1, e1, k);
        if (l1 == 0) return nums2[b2 + k - 1];
        if (k == 1) return Math.min(nums1[b1], nums2[b2]);
        int i, j;
        if (k / 2 > l1) i = b1 + l1 - 1;
        else i = b1 + k / 2 - 1;
        if (k / 2 > l2) j = b2 + l2 - 1;
        else j = b2 + k / 2 - 1;
        if (nums1[i] > nums2[j]) return findK(nums1, b1, e1, nums2, j + 1, e2, k - (j - b2 + 1));
        else return findK(nums1, i + 1, e1, nums2, b2, e2, k - (i - b1 + 1));
    }


    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

}
