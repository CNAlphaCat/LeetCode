package org.alphacat.leetcode.solution.classic.design;

import java.util.HashMap;

public class No1487 {

    //https://alphacat.blog.csdn.net/article/details/106923192
    //https://leetcode-cn.com/problems/making-file-names-unique/
    private HashMap<String, Integer> map;

    public String[] getFolderNames(String[] names) {
        initial();
        String[] res = new String[names.length];
        int index = 0;
        for (String name : names) {
            String realName = getRealFileName(name);
            res[index++] = realName;
        }
        return res;
    }

    private void initial() {
        map = new HashMap<>();
    }

    private String getSuffix(int suffixNum) {
        return "(" + suffixNum + ")";
    }

    private String getRealFileName(String name) {
        if (!map.containsKey(name)) {
            map.put(name, 1);
            return name;
        }
        int suffixNum = map.get(name);
        String crrName = name + getSuffix(suffixNum);
        while (map.containsKey(crrName)) {
            suffixNum++;
            crrName = name + getSuffix(suffixNum);
        }
        map.put(crrName, 1);
        map.put(name,suffixNum+1);//这一步非常重要
        return crrName;
    }

    private String getRealFileName_2(String name) {
        if (!map.containsKey(name)) {
            map.put(name, 1);
            return name;
        }
        int suffixNum = map.get(name);
        String crrName = name + getSuffix(suffixNum);
        while (map.containsKey(crrName)) {
            suffixNum++;
            crrName = name + getSuffix(suffixNum);
        }
        map.put(crrName, 1);
        return crrName;
    }

    private String getRealFileName_3(String name) {
        if (!map.containsKey(name)) {
            map.put(name, 1);
            return name;
        }
        int suffixNum = map.get(name) + 1;
        name = name + getSuffix(suffixNum);
        while (map.containsKey(name)) {
            suffixNum = map.get(name);
            name = name + getSuffix(suffixNum + 1);
        }
        map.put(name, 1);
        return name;
    }

}
