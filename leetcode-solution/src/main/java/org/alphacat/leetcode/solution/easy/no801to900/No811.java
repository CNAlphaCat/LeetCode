package org.alphacat.leetcode.solution.easy.no801to900;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No811 {

    private HashMap<String, Integer> map;

    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] strings = domain.split(" ");
            int count = Integer.valueOf(strings[0]);
            String domainName = strings[1];
            getDomainCount(count, domainName);
        }
        return output();
    }

    private void getDomainCount(int count, String domainName) {
        while (domainName.length() > 0) {
            if (!map.containsKey(domainName)) {
                map.put(domainName, count);
            } else {
                int sumCount = map.get(domainName);
                map.replace(domainName, sumCount + count);
            }
            int dotPosition = domainName.indexOf(".");
            if (dotPosition == -1) {
                break;
            }
            domainName = domainName.substring(dotPosition + 1);
        }
    }

    private List<String> output() {
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            String countString = String.valueOf(count);
            String s = countString+" "+ entry.getKey();
            list.add(s);
        }
        return list;
    }
}
