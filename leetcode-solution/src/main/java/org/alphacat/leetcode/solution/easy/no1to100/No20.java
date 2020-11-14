package org.alphacat.leetcode.solution.easy.no1to100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20. 有效的括号
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
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
public class No20 {

    public boolean isValid(String s) {
        if (s == "" || s == null) {
            return true;
        }
        int n = s.length();
        Stack<Character> stack = new Stack<Character>();
        Character c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (!isBrackets(c)) {
                return false;
            }
            if (!stack.isEmpty() && isCouple(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    boolean isBrackets(Character c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }

    boolean isCouple(Character c1, Character c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        return false;
    }
}
