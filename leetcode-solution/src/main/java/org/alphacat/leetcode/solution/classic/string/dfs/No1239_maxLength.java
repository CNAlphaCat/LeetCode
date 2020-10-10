package org.alphacat.leetcode.solution.classic.string.dfs;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 1239. 串联字符串的最大长度
 * ☆☆☆☆
 * keyword:字符串，位运算，字符串相等，dfs
 * 题解：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solution/dfs-he-wei-ya-suo-by-stalern/
 */
public class No1239_maxLength {

    private final static int SAME_NUM = -1;

    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, 0, 0);
    }

    private int maxLength(List<String> arr, int index, int curLen
            , int bitMap) {
        if (index == arr.size()) {
            return curLen;
        }
        String curStr = arr.get(index);
        int newBitMap = getBitMap(bitMap, curStr);
        int tempLen = 0;
        if (newBitMap != SAME_NUM) {
            tempLen = maxLength(arr, index + 1
                    , curLen + curStr.length(), newBitMap);
        }
        int notContainCurStrLen = maxLength(arr, index + 1, curLen
                , bitMap);
        return Math.max(tempLen, notContainCurStrLen);
    }

    private int getBitMap(int bitMap, String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int temp = 1 << (c - 'a');
            if ((bitMap & temp) != 0) {
                return SAME_NUM;
            }
            bitMap |= temp;
        }
        return bitMap;
    }

}
