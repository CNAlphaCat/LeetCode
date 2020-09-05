package org.alphacat.leetcode.solution.classic.maths;

import java.util.HashMap;
import java.util.HashSet;

public class No202 {

    HashMap<Integer, Integer> map;
    private final int HAPPY_NUM = 1;
    HashSet<Integer> set;

    public boolean isHappy(int n) {
        set = new HashSet<>();
        map = new HashMap<>();
        while (n != HAPPY_NUM && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == HAPPY_NUM;
    }

    private int getNextNum(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        map.put(n, sum);
        return sum;
    }

    public boolean isHappy_2(int n) {

        map = new HashMap<>();
        int slow = n;
        int fast = getNextNum(n);
        while (fast != HAPPY_NUM && slow != fast) {
            fast = getNextNextNum(fast);

            slow = getNextNum(slow);
        }
        return fast == HAPPY_NUM;
    }

    private int getNextNextNum(int n) {
        int num = getNextNum(n);
        return getNextNum(num);
    }


}
