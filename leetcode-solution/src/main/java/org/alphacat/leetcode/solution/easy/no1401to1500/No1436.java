package org.alphacat.leetcode.solution.easy.no1401to1500;

import java.util.HashMap;
import java.util.List;

public class No1436 {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        List<String> firstList = paths.get(0);
        String startPoint = firstList.get(firstList.size() - 1);//从第一个list的终点开始走
        for (int i = 1; i < paths.size(); i++) {
            List<String> list = paths.get(i);
            String begin = list.get(0);
            String end = list.get(list.size() - 1);
            map.put(begin, end);
        }
        while (map.containsKey(startPoint)) {
            startPoint = map.get(startPoint);
        }
        return startPoint;
    }
}
