package org.alphacat.leetcode.solution.classic.maths.convert;

import java.util.ArrayList;
import java.util.List;

public class No12_intToRoman {

    private int tableSize = 13;
    private List<Pair> pairs = getPair();

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            if (num == 0) {
                break;
            }
            int tempNum = pair.num;
            while (num >= tempNum) {
                num -= tempNum;
                sb.append(pair.str);
            }
        }
        return sb.toString();
    }

    private List<Pair> getPair() {
        List<Pair> pairs = new ArrayList<>(tableSize);

        pairs.add(new Pair("M", 1000));
        pairs.add(new Pair("CM", 900));
        pairs.add(new Pair("D", 500));
        pairs.add(new Pair("CD", 400));
        pairs.add(new Pair("C", 100));
        pairs.add(new Pair("XC", 90));
        pairs.add(new Pair("L", 50));
        pairs.add(new Pair("XL", 40));
        pairs.add(new Pair("X", 10));
        pairs.add(new Pair("IX", 9));
        pairs.add(new Pair("V", 5));
        pairs.add(new Pair("IV", 4));
        pairs.add(new Pair("I", 1));

        return pairs;
    }

    class Pair {
        String str;
        int num;

        public Pair(String _str, int _num) {
            str = _str;
            num = _num;
        }
    }
}
