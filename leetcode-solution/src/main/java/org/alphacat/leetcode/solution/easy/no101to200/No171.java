package org.alphacat.leetcode.solution.easy.no101to200;

public class No171 {

    public int titleToNumber(String s) {
        int n = s.length();
        int num = 1;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int digitNum = getNum(c);
            sum += num * digitNum;
            num *= 26;
        }
        return sum;
    }

    private int getNum(char c) {
        return c - 'A' + 1;
    }
}
