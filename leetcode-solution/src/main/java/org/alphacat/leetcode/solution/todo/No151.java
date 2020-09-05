package org.alphacat.leetcode.solution.todo;

import java.util.Iterator;
import java.util.LinkedList;

public class No151 {

    public String reverseWords(String s) {
        LinkedList<String> list = getWords(s);
        if (list.size() == 0) {
            return "";
        }
        Iterator<String> iterator = list.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private LinkedList<String> getWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return list;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        int index = 0;

        while (true) {
            while (index < n && chars[index] == ' ') {
                index++;
            }
            if (index == n) {
                break;
            }
            int begin = index;
            while (index < n && chars[index] != ' ') {
                index++;
            }
            int end = index;
            String word = s.substring(begin, end);
            list.add(word);
        }
        return list;
    }

    public String reverseWords_2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0) {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
