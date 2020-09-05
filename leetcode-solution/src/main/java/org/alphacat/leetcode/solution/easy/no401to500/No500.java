package org.alphacat.leetcode.solution.easy.no401to500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No500 {

    public String[] findWords(String[] words) {
        List<String> list = new LinkedList<>();
        HashMap<Character, Integer> map = getMap();
        for (String word : words) {
            char c = word.charAt(0);
            int line = map.get(c);
            boolean isSameLine = true;
            for (int i = 1; i < word.length(); i++) {
                c = word.charAt(i);
                if (map.get(c) != line) {
                    isSameLine = false;
                    break;
                }
            }
            if (isSameLine) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private HashMap<Character, Integer> getMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        String line_1 = "qwertyuiop";
        String line_2 = "asdfghjkl";
        String line_3 = "zxcvbnm";
        for (char c : line_1.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : line_1.toUpperCase().toCharArray()) {
            map.put(c, 1);
        }
        for (char c : line_2.toCharArray()) {
            map.put(c, 2);
        }
        for (char c : line_2.toUpperCase().toCharArray()) {
            map.put(c, 2);
        }
        for (char c : line_3.toCharArray()) {
            map.put(c, 3);
        }
        for (char c : line_3.toUpperCase().toCharArray()) {
            map.put(c, 3);
        }
        return map;
    }
}
