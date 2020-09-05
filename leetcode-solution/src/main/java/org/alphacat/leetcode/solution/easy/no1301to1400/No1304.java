package org.alphacat.leetcode.solution.easy.no1301to1400;

public class No1304 {


    public int[] sumZero(int n) {
        int[] res = new int[n];
        int baseNum = 1;
        int index = 0;
        if (isEven(n)) {
            res[0] = 0;
            index++;
        }
        while (index < n) {
            res[index++] = baseNum;
            res[index++] = -baseNum;
            baseNum++;
        }
        return res;
    }

    private boolean isEven(int n) {
        return (n & 1) == 1;
    }
}
