package org.alphacat.leetcode.solution.classic.tree;

public class No1483 {

    //hard
    //week competition
    class TreeAncestor {
        int[][] dp;

        public TreeAncestor(int n, int[] parent) {
            int size = (int) (Math.log(n) / Math.log(2)) + 1;
            dp = new int[n][size];
            for (int i = 0; i < n; i++) {
                dp[i][0] = parent[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < size; j++) {
                    int temp = dp[i][j - 1];
                    if (temp != -1) {
                        dp[i][j] = dp[temp][j - 1];
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int index = 0;
            int res = node;
            while (k > 0) {
                if (isOdd(k)) {
                    res = dp[res][index];
                }
                if (res == -1) {
                    return -1;
                }
                index++;
                k >>= 1;
            }
            return res;
        }

        //递归写法
        public int getKthAncestor_2(int node, int k) {
            if (node == -1 || k == 0) {
                return node;
            }
            int index = (int) (Math.log(k) / Math.log(2));
            return getKthAncestor(dp[node][index], k - (1 << index));
        }

        private boolean isOdd(int num) {
            return (num & 1) == 1;
        }
    }
}
