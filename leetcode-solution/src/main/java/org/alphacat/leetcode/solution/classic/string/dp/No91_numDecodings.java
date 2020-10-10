package org.alphacat.leetcode.solution.classic.string.dp;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 * ☆☆☆☆
 * keyword:dp
 */
public class No91_numDecodings {

    private final static int NOT_FOUND_NUM = 0;
    private final static char ZERO = '0';
    private final static char ONE = '1';
    private final static char TWO = '2';
    private final static char SIX = '6';

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == ZERO) {
            return NOT_FOUND_NUM;
        }

        int dp_pre = 1;
        int dp_post = 1;

        for (int i = 1; i < s.length(); ++i) {
            int temp = dp_post;

            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);

            if (cur == ZERO) {
                if (pre == ONE || pre == TWO) {
                    dp_post = dp_pre;
                } else {
                    return NOT_FOUND_NUM;
                }
            } else if (betweenTenAndTwentySix(pre, cur)) {
                dp_post += dp_pre;
            }
            //else dp[i]=dp[i-1]
            //即cur不需要改变

            dp_pre = temp;
        }
        return dp_post;
    }

    private boolean betweenTenAndTwentySix(char pre, char cur) {
        if (pre == ONE) {
            return true;
        }
        if (pre == TWO && (cur >= ONE && cur <= SIX)) {
            return true;
        }
        return false;
    }
}
