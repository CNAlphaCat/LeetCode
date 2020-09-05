package org.alphacat.leetcode.solution.easy.no401to500;

public class No443 {


    public int compress(char[] chars) {

        int arrIndex = 0;
        if (chars == null) {
            return arrIndex;
        }
        int n = chars.length;

        int index = 0;

        while (index < n) {
            char c = chars[index];
            int count = 0;

            while (index < n && chars[index] == c) {
                ++count;
                ++index;
            }

            chars[arrIndex] = c;
            ++arrIndex;

            if (count == 1) {
                continue;
            }

            int digitCount = sizeOfInt(count);

            for (int i = digitCount - 1; i >= 0; --i) {
                chars[arrIndex + i] = (char) (count % 10 + '0');
                count /= 10;
            }

            arrIndex += digitCount;
        }
        return arrIndex;
    }

    private static int sizeOfInt(int x) {
        final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
}
