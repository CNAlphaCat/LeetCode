package org.alphacat.leetcode.solution.classic.integer;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 738. 单调递增的数字
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 *
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
