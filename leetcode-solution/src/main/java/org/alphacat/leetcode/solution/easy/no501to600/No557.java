package org.alphacat.leetcode.solution.easy.no501to600;

public class No557 {

    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split(" ");
        StringBuilder reverseSB = new StringBuilder();
        for (String word : strings) {
            reverseSB.append(word);
            reverseSB.reverse();
            sb.append(reverseSB.toString() + " ");
            reverseSB.delete(0, reverseSB.length());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
