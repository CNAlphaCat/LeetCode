package org.alphacat.leetcode.solution.classic.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No1488  {

    //https://leetcode-cn.com/problems/avoid-flood-in-the-city/
    private List<Integer> exactingWaterDay;
    private HashMap<Integer, Integer> fullLake;
    private int[] ans;

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        initial(n);

        for (int i = 0; i < n; i++) {
            int rain = rains[i];
            if (rain == 0) {
                exactingWaterDay.add(i);
                continue;
            }
            ans[i] = -1;
            if (isFull(rain)) {
                if (!isCanExactingWater()) {
                    return new int[0];
                }
                int lastDay = fullLake.get(rain);//满水的日子
                int position = findPosition(lastDay);
                if (position <= lastDay) {//清空湖的日子必须在这之后
                    return new int[0];
                }
                ans[position] = rain;
                exactingWaterDay.remove(Integer.valueOf(position));
                fullLake.put(rain, i);
                continue;
            }
            fullLake.put(rain, i);
        }
        return ans;
    }

    //因为是能清空水池的日子必然是递增的，所以可以二分查找
    private int findPosition(int lastDay) {
        int h = exactingWaterDay.size() - 1;
        int l = 0;
        while (l < h) {
            int mid = l + ((h - l) >> 1);
            int day = exactingWaterDay.get(mid);
            if (day >= lastDay) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l >= exactingWaterDay.size() ? -1 : exactingWaterDay.get(l);
    }

    private boolean isFull(int rain) {
        return fullLake.containsKey(rain);
    }

    private boolean isCanExactingWater() {
        return !exactingWaterDay.isEmpty();
    }

    private void initial(int n) {
        this.exactingWaterDay = new ArrayList<>();//记录哪一天有抽水的机会
        this.fullLake = new HashMap<>();
        ans = new int[n];
        Arrays.fill(ans, 1);
    }

}
