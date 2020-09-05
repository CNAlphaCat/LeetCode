package org.alphacat.leetcode.solution.classic.string;

import java.util.HashMap;

public class No1160 {

    private int alphabetSize = 26;

    public int countCharacters(String[] words, String chars) {
        int[] alphabetCount = new int[alphabetSize];
        for (char c : chars.toCharArray()) {
            alphabetCount[getIndex(c)]++;
        }
        int count = 0;
        for (String word : words) {
            boolean isMastery = true;
            int[] wordCount = new int[alphabetSize];
            for (char c : word.toCharArray()) {
                wordCount[getIndex(c)]++;
            }
            for (int i = 0; i < alphabetSize; i++) {
                if (wordCount[i] > alphabetCount[i]) {
                    isMastery = false;
                    break;
                }
            }
            if (isMastery) {
                count += word.length();
            }
        }
        return count;
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    public int countCharacters_2(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                continue;
            }
            int count = map.get(c);
            map.replace(c, count + 1);
        }
        int count = 0;
        for (String word : words) {
            boolean isMastery = true;
            HashMap<Character, Integer> tempMap = new HashMap<>();
            tempMap.putAll(map);
            for (char c : word.toCharArray()) {
                if (!tempMap.containsKey(c)) {
                    isMastery = false;
                    break;
                }
                int charCount = tempMap.get(c);
                if (charCount == 1) {
                    tempMap.remove(c);
                    continue;
                }
                tempMap.replace(c, charCount - 1);
            }
            if (isMastery) {
                count += word.length();
            }
        }
        return count;
    }
}
