package org.alphacat.leetcode.solution.classic.string;

import java.util.HashMap;
import java.util.Map;

public class No1180 {

    public int countLetters(String S) {
        int wordCount = 1;
        int sum = 0;
        char lastChar = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char crrChar = S.charAt(i);
            if (lastChar == crrChar) {
                wordCount++;
            } else {
                sum += wordCount * (wordCount + 1) / 2;
                wordCount = 1;
                lastChar = crrChar;
            }
        }
        sum += wordCount * (wordCount + 1) / 2;//处理最后一组
        return sum;
    }

    public int countLetters_2(String S) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int length = S.length();
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j <= length; ++j) {
                String temp = S.substring(i, j);
                if (!isOnly(temp)) {
                    continue;
                }
                if (!map.containsKey(temp)) {
                    map.put(temp, 1);
                } else {
                    int count = map.get(temp);
                    count++;
                    map.replace(temp, count);
                }
            }
        }
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    private boolean isOnly(String s) {
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (c != s.charAt(i)) return false;
        }
        return true;
    }
}
