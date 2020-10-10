package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.ArrayList;
import java.util.List;

public class No93 {

    private final static int MAX_LENGTH = 12;
    private final static int SINGLE_ITEM_LENGTH = 3;
    private final static char ZERO = '0';
    private final static int FRAGMENT_NUM = 4;
    private final static int MAX_IP = 255;
    private final static int MAX_DEPTH = 4;

    public List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        int len = s.length();
        if (len == 0 || len > MAX_LENGTH) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, 0, list, "", 0);
        return list;
    }

    private void restoreIpAddresses(String s, int begin, List<String> list
            , String preFix, int depth) {

        int len = s.length();

        if (begin == len && depth == MAX_DEPTH) {
            list.add(preFix);
            return;
        }

        if (depth == MAX_DEPTH || begin == len) {
            return;
        }

        if (s.charAt(begin) == ZERO) {

            String cur;
            if (preFix.length() == 0) {
                cur = ZERO + "";
            } else {
                cur = preFix + "." + ZERO;
            }

            restoreIpAddresses(s, begin + 1, list, cur, depth + 1);
            return;
        }

        int num = 0;

        for (int i = begin; i < begin + SINGLE_ITEM_LENGTH && i < len; ++i) {

            int currentMaxLen = preFix.length() + (i - begin + 1) +
                    (FRAGMENT_NUM - depth - 1) * SINGLE_ITEM_LENGTH;

            int n = s.charAt(i) - '0';
            num = 10 * num + n;

            if (currentMaxLen < len) {
                continue;
            }

            if (i == begin + SINGLE_ITEM_LENGTH - 1 && num > MAX_IP) {
                break;
            }

            String ip = String.valueOf(num);

            String cur;
            if (preFix.length() == 0) {
                cur = ip + "";
            } else {
                cur = preFix + "." + ip;
            }

            restoreIpAddresses(s, i + 1, list, cur, depth + 1);
        }
    }
}
