package org.alphacat.leetcode.solution.todo;

import java.util.Stack;

public class No224 {

    private char SPACE = ' ';
    private char LEFT_BRACKET = '(';
    private char RIGHT_BRACKET = ')';

    public int calculate(String s) {

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
