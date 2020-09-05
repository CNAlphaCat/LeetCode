package org.alphacat.leetcode.solution.classic.string.identification;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 * 71. 简化路径
 * ☆☆☆☆
 * 字符串，字符串处理，细节
 */
public class No71_simplifyPath {

    private char SLASH = '/';
    private String DOT = ".";
    private String DOUBLE_DOT = "..";
    private String NULL_STRING = "";

    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return NULL_STRING;
        }

        Stack<String> stack = new Stack<>();
        StringBuilder tempWord = new StringBuilder();
        int n = path.length();
        int index = 0;

        while (index < n) {
            char c = path.charAt(index);

            if (c == SLASH) {
                if (tempWord.length() == 0) {
                    ++index;
                    continue;
                }

                String s = tempWord.toString();

                if (s.equals(DOT)) {
                    ++index;
                    tempWord.delete(0, tempWord.length());
                    continue;
                }

                if (s.equals(DOUBLE_DOT)) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                    ++index;
                    tempWord.delete(0, tempWord.length());
                    continue;
                }

                stack.add(s);
                tempWord.delete(0, tempWord.length());
                ++index;
                continue;

            }

            tempWord.append(c);
            ++index;
        }
        if (tempWord.length() > 0) {
            String s = tempWord.toString();
            if (s.equals(DOUBLE_DOT)) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if (s.equals(DOT)) {
                //do nothing
            } else {
                stack.add(s);
            }
        }
        if (stack.size() == 0) {
            return String.valueOf(SLASH);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
            ans.insert(0, SLASH);
        }
        return ans.toString();
    }
}
