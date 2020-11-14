package org.alphacat.leetcode.solution.classic.arr.shuffle;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * 384. 打乱数组
 * ☆☆☆☆
 * keyword:数组，打乱
 * 题解：https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode/
 */
public class No384_shuffle {

    class Solution {

        private int[] curNums;
        private int[] originalNums;
        private int n;

        Random random;

        public Solution(int[] nums) {
            random = new Random();
            this.curNums = nums;
            this.originalNums = nums.clone();
            this.n = nums.length;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            curNums = originalNums;
            originalNums = originalNums.clone();
            return originalNums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < n; i++) {
                int index = getIndex(i);
                swap(curNums, index, i);
            }
            return curNums;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private int getIndex(int min) {
            return random.nextInt(n - min) + min;
        }
    }

}
