package org.alphacat.leetcode.solution.classic.maths;

public class No168_convertToTitle {

    private final int multiplier = 26;

    public String convertToTitle(int n) {
        int remains = n;
        StringBuilder sb = new StringBuilder();
        while (remains > 0) {
            int temp = remains % multiplier;
            char letter = getLetter(temp);
            sb.append(letter);
            if (temp == 0) {
                --remains;//最重要的一步，因为没有0
            }
            remains /= multiplier;
        }
        sb.reverse();
        return sb.toString();
    }

    private char getLetter(int n) {
        if (n == 0) {
            return 'Z';
        }
        return (char) (n - 1 + 'A');
    }
}
