package org.alphacat.leetcode.solution.classic.maths.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * 224. 基本计算器
 * ☆☆☆☆
 * keyword:数学，计算器，逆波兰表达式
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * 150. 逆波兰表达式求值
 * {@link  org.alphacat.leetcode.solution.mid.no1to1000.No150_evalRPN}
 *
 *
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No224_calculate {


    private final static char SPACE = ' ';
    private final static char CHAR_LEFT_BRACKET = '(';
    private final static char RIGHT_BRACKET = ')';
    private final static char PLUS = '+';
    private final static char MINUS = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';

    private final static String LEFT_BRACKET = "(";
    private final static String STING_PLUS = "+";
    private final static String STING_MINUS = "-";
    private final static String STING_MULTIPLY = "*";
    private final static String STING_DIVIDE = "/";

    public int calculate(String s) {
        String[] reversePolish = getReversePolish(s);
        return evalRPN(reversePolish);
    }

    private String[] getReversePolish(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        int n = array.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == SPACE) {
                continue;
            }

            if (Character.isDigit(c)) {

                sb.append(c);
                continue;
            }

            if (sb.length() > 0) {
                res.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if (isOperation(c)) {

                while (!stack.isEmpty()) {
                    String peak = stack.peek();
                    if (peak.equals(LEFT_BRACKET)) {
                        break;
                    }
                    res.add(stack.pop());
                }
                stack.push(String.valueOf(c));
                continue;
            }

            if (c == CHAR_LEFT_BRACKET) {
                stack.push(String.valueOf(c));
            } else if (c == RIGHT_BRACKET) {
                while (!stack.isEmpty()) {
                    String peak = stack.peek();
                    if (peak.equals(LEFT_BRACKET)) {
                        break;
                    }
                    res.add(stack.pop());
                }

                //左括号出栈
                stack.pop();
            }
        }

        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return ListToStringArr(res);
    }

    private boolean isOperation(char s) {
        if (s == PLUS) {
            return true;
        }
        if (s == MINUS) {
            return true;
        }
        if (s == MULTIPLY) {
            return true;
        }
        return s == DIVIDE;
    }

    private String[] ListToStringArr(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

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
        if (operation.equals(STING_PLUS)) {
            return num1 + num2;
        }
        if (operation.equals(STING_MINUS)) {
            return num1 - num2;
        }
        if (operation.equals(STING_MULTIPLY)) {
            return num1 * num2;
        }
        return num1 / num2;
    }

    private boolean isOperation(String s) {
        if (s.equals(STING_PLUS)) {
            return true;
        }
        if (s.equals(STING_MINUS)) {
            return true;
        }
        if (s.equals(STING_MULTIPLY)) {
            return true;
        }
        return s.equals(STING_DIVIDE);
    }
}
