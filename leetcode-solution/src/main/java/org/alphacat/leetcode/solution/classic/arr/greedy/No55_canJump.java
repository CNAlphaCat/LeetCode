package org.alphacat.leetcode.solution.classic.arr.greedy;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 55. 跳跃游戏
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 *
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:数组，贪心
 * 题解：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
 */
public class No55_canJump {

    public boolean canJump(int[] nums) {
        int mostFar = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > mostFar) {
                return false;
            }
            int tempFar = nums[i] + i;
            if (tempFar >= n - 1) {
                return true;
            }
            mostFar = Math.max(tempFar, mostFar);
        }
        return true;
    }
}
