package org.alphacat.leetcode.solution.classic.maths;

public class No1025 {

    public boolean divisorGame(int N) {
        //当N=1时，Alice必输
        //当N=2时，Alice必赢，因为Bob只能取1
        //因此问题转变成了：当Bob面对1的情况的时候Bob必输，Alice只要先手拿到2就必赢
        //因此实际上这是抢2问题，谁先拿到2谁就赢
        //考虑N的取值情况，如果N为偶数，那么只要N>=2且N为偶数
        //我们令N=2*x，那么只要Alice取x，Bob下一轮就只能拿到2
        //推理知：只要N为偶数，Alice必赢
        //那么当N为奇数时，无论Alice怎么操作，只要Bob每次只减1，Alice就不可能在她的回合拿到偶数
        return !isOdd(N);
    }

    private boolean isOdd(int N) {
        return (N & 1) == 1;
    }

    public boolean divisorGame_dynamicPlanning(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
