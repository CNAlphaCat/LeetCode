package org.alphacat.leetcode.solution.easy.no801to900;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No884 {

    private int COMMON_NUM = 1;
    private int UNCOMMON_NUM = 2;

    public String[] uncommonFromSentences(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return new String[0];
        }
        if (A.length() == 0) {
            return uncommonFromSentences(B, A);
        }
        HashMap<String, Integer> wordInA_map = getMap(A);
        HashMap<String, Integer> resultMap = compareWords(B, wordInA_map);
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() == COMMON_NUM) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private HashMap<String, Integer> compareWords(String B
            , HashMap<String, Integer> wordInA_map) {
        if (B.length() == 0) {
            return wordInA_map;
        }
        String[] strings_B = B.split(" ");
        addToMap(wordInA_map, strings_B);
        return wordInA_map;
    }

    private HashMap<String, Integer> getMap(String sentence) {
        String[] strings_A = sentence.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        addToMap(map, strings_A);
        return map;
    }

    private void addToMap(HashMap<String, Integer> map, String[] strings) {
        for (String word : strings) {
            if (!map.containsKey(word)) {
                map.put(word, COMMON_NUM);
                continue;
            }
            map.put(word, UNCOMMON_NUM);
        }
    }
}
