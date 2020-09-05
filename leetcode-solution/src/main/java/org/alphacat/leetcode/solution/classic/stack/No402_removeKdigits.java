package org.alphacat.leetcode.solution.classic.stack;

import java.util.Stack;

public class No402_removeKdigits {

    private char ZERO = '0';

    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] stack = new char[n];
        int count = 0;

        for (int i = 0; i < n; ++i) {
            char digit = num.charAt(i);
            while (count > 0 && k > 0 && stack[count - 1] > digit) {
                --count;
                --k;
            }
            stack[count++] = digit;
        }
        StringBuilder sb = new StringBuilder();
        count -= k;

        boolean isPreZero = true;
        for (int i = 0; i < count; ++i) {
            if (isPreZero && stack[i] == ZERO) {
                continue;
            }
            isPreZero = false;
            sb.append(stack[i]);
        }
        if (sb.length() == 0) {
            sb.append(ZERO);
        }
        return sb.toString();
    }

    public String removeKdigits_2(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            int digit = num.charAt(i) - ZERO;
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                --k;
            }
            stack.push(digit);
        }
        for (int i = 0; i < k; ++i) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == ZERO) {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() == 0) {
            sb.append(ZERO);
        }
        sb.reverse();
        return sb.toString();
    }
}
