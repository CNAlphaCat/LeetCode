package org.alphacat.leetcode.solution.classic.string.window;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 * keyword: 字符串，最长子串，滑动窗口
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int length = 0;
        int n = s.length();
        char c;
        while (i < n && j < n) {
            c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                length = Math.max(length, j - i);
            } else {
                c = s.charAt(i);
                i++;
                set.remove(c);
            }
        }
        return length;
    }
}
