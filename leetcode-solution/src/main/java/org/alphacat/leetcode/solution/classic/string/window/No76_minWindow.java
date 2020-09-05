package org.alphacat.leetcode.solution.classic.string.window;

public class No76_minWindow {

    private final char BEGIN_CHAR = 'A';

    private final int ALPHABET_SIZE = 'z' - BEGIN_CHAR + 1;
    // ASCII码对照表
    // https://tool.ip138.com/ascii_code/

    private final String NULL_STR = "";

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return NULL_STR;
        }
        int[] sCount = new int[ALPHABET_SIZE];
        int[] tCount = new int[ALPHABET_SIZE];

        int l_s = s.length();
        int l_t = t.length();
        if (l_t == 0) {
            return NULL_STR;
        }

        int alphaCount = 0;

        for (int i = 0; i < l_t; ++i) {
            int index = t.charAt(i) - BEGIN_CHAR;
            if (tCount[index] == 0) {
                ++alphaCount;
            }
            ++tCount[index];
        }
        int l = 0;
        int r = 0;
        int count = 0;
        int begin = -1;
        int maxLength = l_t == Integer.MAX_VALUE ? l_s : l_s + 1;
        int length = maxLength;
        while (r < l_s) {
            char c = s.charAt(r);
            int index = c - BEGIN_CHAR;
            if (tCount[index] > 0) {
                ++sCount[index];
                if (sCount[index] == tCount[index]) {
                    ++count;
                }
            }
            while (count == alphaCount) {
                int currentLength = r - l + 1;
                if (currentLength < length) {
                    begin = l;
                    length = currentLength;
                }
                c = s.charAt(l);
                ++l;
                index = c - BEGIN_CHAR;
                if (tCount[index] > 0) {
                    if (tCount[index] == sCount[index]) {
                        --count;
                    }
                    --sCount[index];
                }
            }
            ++r;
        }
        return maxLength == length ? NULL_STR : s.substring(begin, begin + length);
    }
}
