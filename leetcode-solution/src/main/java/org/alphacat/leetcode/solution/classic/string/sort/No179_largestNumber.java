package org.alphacat.leetcode.solution.classic.string.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * 179. 最大数
 * ☆☆☆☆
 * keyword:字符串，排序，字符串拼接
 * 题解：https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/
 */
public class No179_largestNumber {

    private final static String ZERO = "0";

    public String largestNumber(int[] nums) {
        if (nums == null) {
            return ZERO;
        }
        int n = nums.length;
        if (n == 0) {
            return ZERO;
        }

        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        if (strArr[0].equals(ZERO)) {
            return ZERO;
        }

        StringBuilder sb = new StringBuilder();

        for (String s : strArr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
