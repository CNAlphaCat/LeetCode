package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.*;

public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        int alphabetSize = 26;
        int[] letterCount = new int[alphabetSize];
        StringBuilder sb = new StringBuilder();
        HashMap<String, List> map = new HashMap<>();

        for (String s : strs) {
            Arrays.fill(letterCount, 0);
            for (char c : s.toCharArray()) {
                ++letterCount[c - 'a'];
            }
            for (int i = 0; i < alphabetSize; ++i) {
                sb.append(letterCount[i]);
                sb.append("#");
            }
            String key = sb.toString();
            sb.delete(0, sb.length());
            if (map.containsKey(key)) {
                List list = map.get(key);
                list.add(s);
                map.put(key, list);
                continue;
            }
            List<String> temp = new LinkedList<>();
            temp.add(s);
            map.put(key, temp);
        }
        List<List<String>> ans = new ArrayList<>(map.size());
        for (Map.Entry<String, List> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
