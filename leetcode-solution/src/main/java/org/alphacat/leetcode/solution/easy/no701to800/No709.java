package org.alphacat.leetcode.solution.easy.no701to800;

public class No709 {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cStr = str.toCharArray();
        for (int i = 0; i < cStr.length; i++) {
            if (isUpperCase(cStr[i])) {
                cStr[i] -= getASCIIDiff();
            }
        }
        return String.valueOf(cStr);
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private int getASCIIDiff() {
        return 'A' - 'a';
    }
}
