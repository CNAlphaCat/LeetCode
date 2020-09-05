package org.alphacat.leetcode.solution.mid.no1001to1500;

import java.util.HashMap;
import java.util.Map;

public class No1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int temp : arr) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                int count = map.get(temp);
                map.replace(temp, count + 1);
            }
        }
        int count = 0;
        int numCount = 1;
        int removeCount = 0;
        while (count < k) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == numCount) {
                    count += numCount;
                    removeCount++;
                }
                if (count > k) {
                    removeCount--;
                }
                if (count >= k) {
                    break;
                }
            }
            numCount++;
        }
        return map.size() - removeCount;
    }
}
