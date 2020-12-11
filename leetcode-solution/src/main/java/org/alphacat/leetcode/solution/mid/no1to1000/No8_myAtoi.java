package org.alphacat.leetcode.solution.mid.no1to1000;

public class No8_myAtoi {

    public int myAtoi(String str) {
        if (strIsNull(str)) {
            return 0;
        }

        str = removeSpace(str);
        int len = str != null ? str.length() : 0;
        if (len == 0){
            return 0;
        }

        int res = 0, i = 0, temp = 0;
        Character c = str.charAt(0);
        int flag = plusOrMinus(c);
        if (c == '+' || c == '-') {
            i++;
        }
        while (i < len) {
            c = str.charAt(i);
            if (!isDigit(c)) {
                break;
            }
            temp = charToInt(c) * flag;
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }

            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && temp < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + temp;
            i++;
        }
        return res;
    }

    public String removeSpace(String str) {
        int i = 0, len = strIsNull(str) ? 0 : str.length();
        while (i <= len - 1 && str.charAt(i) == ' ') {
            i++;
        }

        if (i > len - 1) {
            return null;
        }
        return str.substring(i, len);
    }

    public int plusOrMinus(Character c) {
        if (c == '+') {
            return 1;
        } else if (c == '-') {
            return -1;
        }
        return 1;
    }

    public boolean isDigit(Character c) {
        if (c > '9' || c < '0') {
            return false;
        }
        return true;
    }

    public int charToInt(Character c) {
        return c - '0';
    }

    public boolean strIsNull(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }
}
