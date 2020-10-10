package org.alphacat.leetcode.solution.classic.maths.calculate;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * 224. 基本计算器
 * ☆☆☆☆
 * keyword:数学，计算器
 */
public class No224_calculate_official {

    private final static char SPACE = ' ';
    private final static char LEFT_BRACKET = '(';
    private final static char RIGHT_BRACKET = ')';
    private final static char PLUS = '+';
    private final static char MINUS = '-';

    private final static int POSITIVE = 1;
    private final static int NEGATIVE = -1;

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int sign = POSITIVE;
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';
            } else if (c == PLUS) {
                ans += sign * operand;
                sign = POSITIVE;
                operand = 0;
            } else if (c == MINUS) {
                ans += sign * operand;
                sign = NEGATIVE;
                operand = 0;
            } else if (c == LEFT_BRACKET) {
                stack.push(ans);
                stack.push(sign);
                sign = POSITIVE;
                ans = 0;
            } else if (c == RIGHT_BRACKET) {
                ans += sign * operand;
                ans *= stack.pop();
                ans += stack.pop();
                operand = 0;
            }
        }
        return ans + operand * sign;
    }

    public int calculate_2(String s) {

        int operand = 0;
        int digitCount = 0;
        int n = s.length();
        Stack<Object> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {

                int num = c - '0';
                operand = (int) Math.pow(10, digitCount) * num + operand;
                ++digitCount;
                continue;

            }

            if (c == SPACE) {
                continue;
            }


            if (digitCount != 0) {

                stack.push(operand);
                digitCount = 0;
                operand = 0;

            }

            if (c == LEFT_BRACKET) {

                evaluate(stack);

            } else {
                stack.push(c);
            }

        }

        if (digitCount != 0) {
            stack.push(operand);
        }

        return evaluate(stack);
    }

    public int evaluate(Stack<Object> stack) {

        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        while (!stack.empty()) {

            char sign = (char) stack.pop();

            if (sign == RIGHT_BRACKET) {
                break;
            }

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        stack.push(res);

        return res;
    }

}
