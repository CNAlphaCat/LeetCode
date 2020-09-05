package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 150. 逆波兰表达式求值
 * ☆☆☆
 * 逆波兰表达式
 */
public class No150_evalRPN {

    private String PLUS = "+";
    private String MINUS = "-";
    private String MULTIPLY = "*";
    private String DIVIDE = "/";

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!isOperation(token)) {
                Integer num = Integer.valueOf(token);
                stack.add(num);
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = calculate(num1, num2, token);
                stack.add(res);
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operation) {
        if (operation.equals(PLUS)) {
            return num1 + num2;
        }
        if (operation.equals(MINUS)) {
            return num1 - num2;
        }
        if (operation.equals(MULTIPLY)) {
            return num1 * num2;
        }
        return num1 / num2;
    }

    private boolean isOperation(String s) {
        if (s.equals(PLUS)) {
            return true;
        }
        if (s.equals(MINUS)) {
            return true;
        }
        if (s.equals(MULTIPLY)) {
            return true;
        }
        return s.equals(DIVIDE);
    }
}
