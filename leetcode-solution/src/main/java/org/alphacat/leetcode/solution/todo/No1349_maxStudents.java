package org.alphacat.leetcode.solution.todo;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-students-taking-exam/
 * 1349. 参加考试的最大学生数
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。
 * 如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 *
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，
 * 但是看不到直接坐在他前面或者后面的学生的答卷。
 * 请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
 *
 * 学生必须坐在状况良好的座位上。
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:记忆化递归 + 状态压缩
 * 题解：https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/can-jia-kao-shi-de-zui-da-xue-sheng-shu-ya-suo-zhu/
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * 没全懂
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No1349_maxStudents {

    private static final int INITIAL_NUM = -1;
    private static final char VALID_SEAT = '.';

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        // 所有可能的情况的穷举数量
        int statusSize = 1 << n;
        int[] valid = new int[m];

        // 第一维表示每一行，第二维表示所有可穷举的情况
        int[][] dp = new int[m][statusSize];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valid[i] = (valid[i] << 1) + (seats[i][j] == VALID_SEAT ? 1 : 0);
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], INITIAL_NUM);
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < statusSize; j++) {

                if (!isValidPos(valid[i], j)) {
                    continue;
                }

                //左右有人
                if ((j & (j >> 1)) != 0) {
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = Integer.bitCount(j);
                } else {
                    for (int k = 0; k < statusSize; k++) {
                        if (isValid(dp, i, j, k)) {
                            dp[i][j] = Math.max(dp[i - 1][k] + Integer.bitCount(j), dp[i][j]);
                        }
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private boolean isValid(int[][] dp, int i, int j, int k) {
        if (dp[i - 1][k] == INITIAL_NUM) {
            return false;
        }

        if ((j & (k >> 1)) != 0) {
            return false;
        }

        if (((j >> 1) & k) != 0) {
            return false;
        }

        return true;
    }


    private boolean isValidPos(int validNum, int j) {
        return (j & validNum) == j;
    }
}
