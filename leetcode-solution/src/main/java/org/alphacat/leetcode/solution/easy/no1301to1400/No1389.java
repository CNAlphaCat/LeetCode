package org.alphacat.leetcode.solution.easy.no1301to1400;

import java.util.HashMap;
import java.util.LinkedList;

public class No1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] res = new int[n];
        int crrSize = 0;
        for (int i = 0; i < n; i++) {
            crrSize++;
            int insertPosition = index[i];
            for (int j = crrSize - 1; j > insertPosition && j >= 1; j--) {
                res[j] = res[j - 1];
            }
            res[insertPosition] = nums[i];
        }
        return res;
    }

    //错误代码
    //输入:
    //[4,2,4,3,2]
    //[0,0,1,3,1]
    //输出
    //[2,4,2,4,3]
    //预期结果
    //[2,2,4,4,3]
    public int[] createTargetArray_2(int[] nums, int[] index) {
        int n = nums.length;
        HashMap<Integer, LinkedList> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int tempKey = index[i];
            if (map.containsKey(tempKey)) {
                LinkedList list = map.get(tempKey);
                list.add(i);
                map.replace(tempKey, list);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(tempKey, list);
            }
        }
        int arrIndex = 0;
        int[] res = new int[n];
        for (int i = 0; i < n && arrIndex < n; i++) {
            LinkedList<Integer> list = map.get(i);
            if (list == null) {
                continue;
            }
            for (Integer tempInt : list) {
                res[arrIndex] = nums[tempInt.intValue()];
                arrIndex++;
            }
        }
        return res;
    }
}
