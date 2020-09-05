package org.alphacat.leetcode.solution.classic.comprehension;

public class No521 {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
