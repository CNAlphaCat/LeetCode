package org.alphacat.leetcode.solution.easy.no1301to1400;

public class No1342 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (isOdd(num)) {
                num -= 1;
            } else {
                num /= 2;
            }
            count++;
        }
        return count;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1 ? true : false;
    }
}
