package org.alphacat.leetcode.solution.easy.no801to900;

import java.util.HashSet;
import java.util.Set;

public class No804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] temp = word.toCharArray();
            for (char c : temp) {
                int index = getIndex(c);
                sb.append(morse[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }


    private int getIndex(char c) {
        return c - 'a';
    }
}
