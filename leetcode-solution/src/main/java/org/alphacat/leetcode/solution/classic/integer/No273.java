package org.alphacat.leetcode.solution.classic.integer;

import java.util.HashMap;

public class No273 {

    private HashMap<Integer, String> digitTenMap = getDigitTenMap();
    private HashMap<Integer, String> digitLessThan20Map = getDigitLessThan20Map();


    private final String STR_HUNDRED = "Hundred";
    private final String ZERO = "Zero";
    private final String BILLION = "Billion";
    private final String MILLION = "Million";
    private final String THOUSAND = "Thousand";

    private final int TEN = 10;
    private final int ONE_HUNDRED = 100;
    private final int ONE_BILLION = 1000000000;
    private final int ONE_MILLION = 1000000;
    private final int ONE_THOUSAND = 1000;

    public String numberToWords(int num) {
        if (num == 0) {
            return ZERO;
        }
        int billion = num / ONE_BILLION;
        int million = (num - billion * ONE_BILLION) / ONE_MILLION;
        int thousand = (num - billion * ONE_BILLION - million * ONE_MILLION) / ONE_THOUSAND;
        int hundred = num - billion * ONE_BILLION - million * ONE_MILLION - thousand * ONE_THOUSAND;
        StringBuilder sb = new StringBuilder();
        if (billion != 0) {
            sb = getHundred(billion, sb);
            sb.append(" " + BILLION + " ");
        }
        if (million != 0) {
            sb = getHundred(million, sb);
            sb.append(" " + MILLION + " ");
        }
        if (thousand != 0) {
            sb = getHundred(thousand, sb);
            sb.append(" " + THOUSAND + " ");
        }
        if (hundred != 0) {
            sb = getHundred(hundred, sb);
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private StringBuilder getHundred(int num, StringBuilder sb) {
        int hundred = num / ONE_HUNDRED;
        int tenDigits = num - ONE_HUNDRED * hundred;
        if (hundred > 0 && tenDigits > 0) {
            sb.append(digitLessThan20Map.get(hundred));
            sb.append(" " + STR_HUNDRED + " ");
            sb = getTen(tenDigits, sb);
        }
        if (hundred == 0 && tenDigits > 0) {
            sb = getTen(tenDigits, sb);
        }
        if (hundred > 0 && tenDigits == 0) {
            sb.append(digitLessThan20Map.get(hundred));
            sb.append(" " + STR_HUNDRED);
        }
        return sb;
    }

    private StringBuilder getTen(int num, StringBuilder sb) {
        if (num == 0) {
            return sb;
        }
        if (num >= 1 && num <= 19) {
            sb.append(digitLessThan20Map.get(num));
            return sb;
        }
        int tenDigit = num / TEN;
        int singleNum = num - TEN * tenDigit;
        sb.append(digitTenMap.get(tenDigit));
        if (singleNum != 0) {
            sb.append(" " + digitLessThan20Map.get(singleNum));
        }
        return sb;
    }

    private HashMap<Integer, String> getDigitTenMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "Twenty");
        map.put(3, "Thirty");
        map.put(4, "Forty");
        map.put(5, "Fifty");
        map.put(6, "Sixty");
        map.put(7, "Seventy");
        map.put(8, "Eighty");
        map.put(9, "Ninety");
        return map;
    }

    private HashMap<Integer, String> getDigitLessThan20Map() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        return map;
    }
}
