package org.alphacat.leetcode.solution.easy.no1401to1500;

import java.util.ArrayList;
import java.util.List;

public class No1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        int n = candies.length;
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, candies[i]);
        }
        for (int temp : candies) {
            if (temp + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
