package org.alphacat.leetcode.solution.classic.greed;

/**
 * https://leetcode-cn.com/problems/gas-station/
 * 134. 加油站
 * ☆☆☆☆
 */
public class No134_canCompleteCircuit {

    private int NOT_FOUND_NUM = -1;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int site = 0;
        int curSum = 0;
        for (int i = 0; i < gas.length; ++i) {
            int diff = gas[i] - cost[i];
            sum += diff;
            curSum += diff;
            if (curSum < 0) {
                curSum = 0;
                site = i + 1;
            }
        }
        return sum >= 0 ? site : NOT_FOUND_NUM;
    }
}
