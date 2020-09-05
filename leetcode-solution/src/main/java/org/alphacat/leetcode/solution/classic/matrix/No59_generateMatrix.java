package org.alphacat.leetcode.solution.classic.matrix;

public class No59_generateMatrix {

    // 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0;
        int y = 0;
        int num = 1;
        int maxNum = n * n;

        while (true) {
            while (y < n && ans[x][y] == 0) {
                ans[x][y] = num;
                ++num;
                ++y;
            }
            --y;
            ++x;
            if (num > maxNum) {
                break;
            }

            while (x < n && ans[x][y] == 0) {
                ans[x][y] = num;
                ++num;
                ++x;
            }
            --x;
            --y;
            if (num > maxNum) {
                break;
            }

            while (y >= 0 && ans[x][y] == 0) {
                ans[x][y] = num;
                ++num;
                --y;
            }
            ++y;
            --x;

            if (num > maxNum) {
                break;
            }

            while (x >= 0 && ans[x][y] == 0) {
                ans[x][y] = num;
                ++num;
                --x;
            }
            ++x;
            ++y;
            if (num > maxNum) {
                break;
            }

        }
        return ans;
    }
}
