package org.alphacat.leetcode.solution.classic.string;

import java.util.Arrays;
import java.util.HashSet;

public class No893 {

    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String s : A) {
            int[] stringCount = new int[52];//26个字母，因为只能交换偶数下标，所以a-z要分两块计数
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = getIndex(c, i);
                stringCount[index]++;
            }
            String serializeString = Arrays.toString(stringCount);//将生成的数组序列化，方便进行比较
            set.add(serializeString);//这一步隐含了一个过程：相同的话add是不会增加set的size的
        }
        return set.size();
    }

    private int getIndex(char c, int i) {
        return c - 'a' + 26 * (i % 2);
    }

    //更直观的写法
    private int getIndex_2(char c, int i) {
        if (i % 2 == 0) {
            return c - 'a';
        }
        return c - 'a' + 26;
    }

    HashSet<String> set;

    public int numSpecialEquivGroups_2(String[] A) {
        set = new HashSet<>();
        int ans = 0;
        for (String s : A) {
            if (!set.contains(s)) {
                ans++;
                getSpecialString(s.toCharArray(), 0);
            }
        }
        return ans;
    }

    private void getSpecialString(char[] chars, int begin) {
        int n = chars.length;
        if (begin == n) {
            set.add(String.valueOf(chars));
        }
        for (int i = begin; i < n; i += 2) {
            swap(chars, begin, i);
            getSpecialString(chars, begin + 1);
            swap(chars, begin, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
