package org.alphacat.leetcode.solution.classic.string;



import org.alphacat.test.framework.leetcodetest.LeetCodeTest_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No1047 implements LeetCodeTest_1<String, String> {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int i = 0;
        char[] chars = S.toCharArray();//使用chars比直接读S.charAt(i)效率更高
        while (i < n) {
            if (i + 1 < n && chars[i] == chars[i + 1]) {
                i += 2;
                continue;
            }
            int sbLength = sb.length();
            if (sbLength > 0 && sb.charAt(sbLength - 1) == chars[i]) {
                sb.deleteCharAt(sbLength - 1);
                i++;
                continue;
            }
            sb.append(chars[i]);
            i++;
        }
        return sb.toString();
    }

    public String removeDuplicates_2(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
    }

    public String removeDuplicates_3(String S) {
        StringBuilder sb = new StringBuilder(S);
        while (true) {
            int size = sb.length();
            for (int i = 0; i < size - 1; i++) {
                if (sb.charAt(i) != sb.charAt(i + 1)) {
                    continue;
                } else {
                    sb.delete(i, i + 2);
                    break;
                }
            }
            if (sb.length() == size) {
                break;
            }
        }
        return sb.toString();
    }

    @Override
    public List<String[]> getOriginalCase() {
        List<String[]> list = new LinkedList<>();
        addToList(list, "abbbabaaa", "ababa");
        return list;
    }

    @Override
    public String testTask(String s) {
        return removeDuplicates(s);
    }
}
