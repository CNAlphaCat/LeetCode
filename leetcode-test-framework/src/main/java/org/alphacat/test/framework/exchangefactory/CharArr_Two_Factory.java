package org.alphacat.test.framework.exchangefactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CharArr_Two_Factory implements TestHelperFactory<char[][]> {
    @Override
    public char[][] deserialize(String s) {
        if (s == null) {
            return new char[0][];
        }
        s = s.replace("\"", "");
        int n = s.length();
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        Queue<char[]> queue = new LinkedList<char[]>();
        int m = n;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == ',')
                continue;
            if (c != ']') {
                s1.add(c);
            } else {
                while (!s1.isEmpty()) {
                    char c1 = s1.pop();
                    if (c1 != '[') {
                        s2.add(c1);
                    }
                }
                int size = s2.size();
                if (size == 0) {
                    continue;
                }
                m = size;
                char[] cArr = new char[size];
                for (int j = 0; j < m; ++j) {
                    cArr[j] = s2.pop();
                }
                queue.add(cArr);
            }
        }
        int qSize = queue.size();
        char[][] res = new char[qSize][m];
        for (int i = 0; i < qSize; ++i) {
            char[] temp = queue.poll();
            res[i] = temp;
        }
        return res;
    }

    @Override
    public String serialize(char[][] output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int m = output.length;
        int n = output[0].length;
        for (char[] chars : output) {
            sb.append("[");
            for (char c : chars) {
                sb.append(c);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}
