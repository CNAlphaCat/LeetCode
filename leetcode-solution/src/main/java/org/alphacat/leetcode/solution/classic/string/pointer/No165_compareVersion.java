package org.alphacat.leetcode.solution.classic.string.pointer;


public class No165_compareVersion {

    private final char ZERO = '0';
    private final char DOT = '.';

    private int BIGGER = 1;
    private int EQUAL = 0;
    private int LESS = -1;

    public int compareVersion(String version1, String version2) {
        int l_1 = version1.length();
        int l_2 = version2.length();
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int i_1 = 0;
        int i_2 = 0;
        while (i_1 < l_1 || i_2 < l_2) {
            Pair p_1 = getNum(v1, i_1);
            int num_1 = p_1.num;
            i_1 = p_1.index;

            Pair p_2 = getNum(v2, i_2);
            int num_2 = p_2.num;
            i_2 = p_2.index;

            if (num_1 > num_2) {
                return BIGGER;
            }
            if (num_2 > num_1) {
                return LESS;
            }
        }
        return EQUAL;
    }

    private Pair getNum(char[] chars, int begin) {
        int index = begin;
        int n = chars.length;
        while (index < n && chars[index] == ZERO) {
            ++index;
        }
        if (index == n) {
            return new Pair(n, 0);
        }
        if (chars[index] == DOT) {
            return new Pair(index + 1, 0);
        }
        int end = index;
        while (end < n && chars[end] != DOT) {
            ++end;
        }
        int num = getNum(chars, index, end - 1);
        if (end == n) {
            return new Pair(n, num);
        } else {
            return new Pair(end + 1, num);
        }
    }

    private int getNum(char[] chars, int begin, int end) {
        int num = 0;
        int multiplier = 1;
        for (int i = end; i >= begin; --i) {
            num += multiplier * (int) chars[i];
            multiplier *= 10;
        }
        return num;
    }

    class Pair {
        int index;
        int num;

        public Pair(int _index, int _num) {
            this.index = _index;
            this.num = _num;
        }
    }
}
