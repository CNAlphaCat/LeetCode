package org.alphacat.leetcode.solution.classic.string;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/can-make-palindrome-from-substring/
 * 1177. 构建回文串检测
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 *
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。
 * 我们可以 重新排列 子串 s[left], ..., s[right]，
 * 并从中选择 最多 k 项替换成任何小写英文字母。
 *
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 *
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 *
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，
 * 也就是说，如果 s[left..right] = "aaa" 且 k = 2，
 * 我们只能替换其中的两个字母。
 * （另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No1177_canMakePaliQueries {

    private static final int NUM_COUNT = 26;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int QUERIES_INDEX = 2;

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        if (queries.length == 0) {
            return new ArrayList<>();
        }

        int[][] charCount = new int[s.length()][NUM_COUNT];

        for (int i = 0; i < s.length(); i++) {
            ++charCount[i][s.charAt(i) - 'a'];
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < NUM_COUNT; j++) {
                charCount[i][j] += charCount[i - 1][j];
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][BEGIN_INDEX] - 1;
            int end = queries[i][END_INDEX];
            int count = 0;
            if (start >= 0) {
                for (int j = 0; j < NUM_COUNT; j++) {
                    int tempCount = charCount[end][j] - charCount[start][j];
                    if ((tempCount & 1) == 1) {
                        ++count;
                    }
                }
            } else {
                for (int j = 0; j < NUM_COUNT; j++) {
                    if ((charCount[end][j] & 1) == 1) {
                        ++count;
                    }
                }
            }

            if (count <= queries[i][QUERIES_INDEX] * 2 + 1) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
