package org.alphacat.leetcode.solution.classic.dp;

public class No873 {

    //其实没玩过21点的话可能不太懂这个题的意思，可以了解一下21点的规则再看这题

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }

        //dp[i]代表当当前点数=i的时候，Alice获胜（也就是再抽牌小于这个数）的概率
        double[] dp = new double[K + W];

        for (int i = K; i < K + W && i <= N; ++i) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; --i) {
            for (int j = 1; j <= W; ++j) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }

    //根据转移方程继续优化

    public double new21Game_2(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i < K + W && i <= N; ++i) {
            dp[i] = 1.0;
        }
        dp[K - 1] = Math.min(N - K + 1, W) * 1.0 / W;
        for (int i = K - 2; i >= 0; --i) {
            dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + W + 1]) / W;
        }
        return dp[0];
    }
}
