package org.alphacat.leetcode.solution.classic.arr;

import java.util.*;

public class No1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        List list;
        for (int i = 0; i < groupSizes.length; i++) {
            int peopleCount = groupSizes[i];
            if (!map.containsKey(peopleCount)) {
                list = new ArrayList();
                list.add(i);
                if (list.size() == peopleCount) {
                    res.add(list);
                    map.remove(peopleCount);
                } else {
                    map.put(peopleCount, list);
                }
            } else {
                list = map.get(peopleCount);
                list.add(i);
                if (list.size() == peopleCount) {
                    res.add(list);
                    map.remove(peopleCount);
                } else {
                    map.replace(peopleCount, list);
                }
            }
        }
        return res;
    }

    //第一版的代码，实际上完全可以变放边判断
    public List<List<Integer>> groupThePeople_2(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List list;
        for (int i = 0; i < groupSizes.length; i++) {
            int peopleCount = groupSizes[i];
            if (!map.containsKey(peopleCount)) {
                list = new ArrayList();
                list.add(i);
                map.put(peopleCount, list);
            } else {
                list = map.get(peopleCount);
                list.add(i);
                map.replace(peopleCount, list);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> entryList = entry.getValue();
            Integer peopleCount = entry.getKey();
            int j = 0;
            for (int i = 0; i < entryList.size() / peopleCount; i++) {
                List<Integer> tempList = new ArrayList<>();
                for (int z = 0; z < peopleCount; z++) {
                    tempList.add(entryList.get(j++));
                }
                res.add(tempList);
            }
        }
        return res;
    }


}
