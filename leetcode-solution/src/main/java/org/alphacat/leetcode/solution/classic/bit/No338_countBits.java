package org.alphacat.leetcode.solution.classic.bit;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. 比特位计数
 * ☆☆☆☆
 * keyword:位，dp
 * 题解：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
 */
public class No338_countBits {

    public int[] countBits(int num) {

        int[] dp = new int[num + 1];

        for (int i = 0; i <= num; i++) {


            if ((i & 1) == 1) {
                //奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
                dp[i] = dp[i - 1] + 1;
            } else {
                //偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
                // 因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }

    public int[] countBits_2(int num) {

        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    public int[] countBits_3(int num) {

        int[] dp = new int[num + 1];

        int i = 0;
        int offset = 1;

        while (offset <= num) {

            while (i < offset && i + offset <= num) {
                dp[i + offset] = dp[i] + 1;
                ++i;
            }
            i = 0;
            offset <<= 1;
        }


        return dp;
    }
}
