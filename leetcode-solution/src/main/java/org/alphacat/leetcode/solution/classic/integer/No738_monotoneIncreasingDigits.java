package org.alphacat.leetcode.solution.classic.integer;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 738. 单调递增的数字
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No738_monotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        String num = String.valueOf(N);
        char[] numChars = num.toCharArray();

        int index = 0;

        while (index + 1 < num.length() && numChars[index] <= numChars[index + 1]) {
            ++index;
        }

        while (index >= 0 && index + 1 < num.length() && numChars[index] > numChars[index + 1]) {
            --numChars[index];
            --index;
        }

        for (int i = index + 2; i < num.length(); i++) {
            numChars[i] = '9';
        }

        num = String.valueOf(numChars);
        return Integer.parseInt(num);
    }
}
