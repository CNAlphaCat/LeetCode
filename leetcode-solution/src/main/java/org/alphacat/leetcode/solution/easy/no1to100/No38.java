package org.alphacat.leetcode.solution.easy.no1to100;

public class No38 {

    public String countAndSay(int n) {

        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < n; ++i) {

            String s = sb.toString();
            int index = 0;
            int len = s.length();
            sb.delete(0, sb.length());

            while (index < len) {
                int count = getCount(s, index);
                char c = s.charAt(index);

                sb.append(count);
                sb.append(c);

                index += count;
            }
        }
        return sb.toString();
    }

    private int getCount(String s, int index) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (index >= n) {
            return 0;
        }
        int count = 1;
        char c = s.charAt(index);
        int i = index + 1;
        while (i < n) {
            if (c == s.charAt(i)) {
                ++count;
                ++i;
            } else {
                break;
            }
        }
        return count;
    }
}
