package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17 {

    HashMap<Character, List> map = getMap();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>(0);
        }
        char[] chars = digits.toCharArray();

        List<String> list = map.get(chars[0]);

        int n = digits.length();
        int size = (int) Math.pow(4, n);
        List<String> ans = new ArrayList<>(size);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            ans = letterCombinations(chars, sb, 1, ans);
            sb.deleteCharAt(0);
        }
        return ans;
    }

    private List<String> letterCombinations(char[] digits, StringBuilder sb, int position
            , List<String> ans) {
        int n = digits.length;
        if (position == n) {
            ans.add(sb.toString());
            return ans;
        }
        List<String> list = map.get(digits[position]);
        for (String letter : list) {
            sb.append(letter);
            ans = letterCombinations(digits, sb, position + 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        return ans;
    }

    private HashMap<Character, List> getMap() {
        HashMap<Character, List> map = new HashMap<>();

        ArrayList<String> list_2 = new ArrayList<>(3);
        list_2.add("a");
        list_2.add("b");
        list_2.add("c");
        map.put('2', list_2);

        ArrayList<String> list_3 = new ArrayList<>(3);
        list_3.add("d");
        list_3.add("e");
        list_3.add("f");
        map.put('3', list_3);

        ArrayList<String> list_4 = new ArrayList<>(3);
        list_4.add("g");
        list_4.add("h");
        list_4.add("i");
        map.put('4', list_4);

        ArrayList<String> list_5 = new ArrayList<>(3);
        list_5.add("j");
        list_5.add("k");
        list_5.add("l");
        map.put('5', list_5);

        ArrayList<String> list_6 = new ArrayList<>(3);
        list_6.add("m");
        list_6.add("n");
        list_6.add("o");
        map.put('6', list_6);

        ArrayList<String> list_7 = new ArrayList<>(4);
        list_7.add("p");
        list_7.add("q");
        list_7.add("r");
        list_7.add("s");
        map.put('7', list_7);

        ArrayList<String> list_8 = new ArrayList<>(3);
        list_8.add("t");
        list_8.add("u");
        list_8.add("v");
        map.put('8', list_8);

        ArrayList<String> list_9 = new ArrayList<>(4);
        list_9.add("w");
        list_9.add("x");
        list_9.add("y");
        list_9.add("z");
        map.put('9', list_9);

        return map;
    }

}
