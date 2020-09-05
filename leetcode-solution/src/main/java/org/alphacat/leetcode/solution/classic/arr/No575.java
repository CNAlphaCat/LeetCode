package org.alphacat.leetcode.solution.classic.arr;

import java.util.HashSet;

//https://leetcode-cn.com/problems/distribute-candies/
public class No575 {

    public int distributeCandies(int[] candies) {
        int half = candies.length >> 1;
        boolean[] visited = new boolean[200001];//数组中数字的大小在范围[-100,000, 100,000]内。
        int count = 0;
        for (int candy : candies) {
            int index = getIndex(candy);
            if (!visited[index]) {
                visited[index] = true;
                count++;
            }
            if (count == half) {
                break;
            }
        }
        return count;
    }

    private int getIndex(int candy) {
        return candy + 100000;//负数偏移
    }

    public int distributeCandies_2(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
