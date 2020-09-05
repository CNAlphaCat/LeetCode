package org.alphacat.leetcode.solution.easy.no1201to1300;

public class No1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int xDiff = Math.abs(points[i][0] - points[i - 1][0]);
            int yDiff = Math.abs(points[i][1] - points[i - 1][1]);
            res += Math.max(yDiff, xDiff);
        }
        return res;
    }
}
