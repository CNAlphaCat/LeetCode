package org.alphacat.leetcode.solution.easy.no701to800;

import java.util.HashMap;

public class No771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones_2(String J, String S) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();//比用Set更优
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if (map.containsKey(c)) {
                count += map.get(c);
            }
        }
        return count;
    }
}
