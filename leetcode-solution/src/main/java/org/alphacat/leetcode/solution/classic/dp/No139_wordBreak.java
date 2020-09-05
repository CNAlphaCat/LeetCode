package org.alphacat.leetcode.solution.classic.dp;

import java.util.HashSet;
import java.util.List;

public class No139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int maxLength = 0;
        for (String word : wordDict) {
            set.add(word);
            maxLength = Math.max(maxLength, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; ++j) {
            for (int i = j; i >= 0 && j - i <= maxLength; --i) {
                if (!dp[i]) {
                    continue;
                }
                String sub = s.substring(i, j);
                if (set.contains(sub)) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
