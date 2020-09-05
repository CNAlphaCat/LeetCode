package org.alphacat.leetcode.solution.easy.no801to900;

public class No832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length;
        boolean isEven = isEven(n);
        for (int[] column : A) {
            for (int j = 0; j < n / 2; j++) {
                int temp = column[j];
                column[j] = changeNum(column[n - j - 1]);
                column[n - j - 1] = changeNum(temp);
            }
            if (isEven) {
                column[n / 2] = changeNum(column[n / 2]);
            }
        }
        return A;
    }

    private boolean isEven(int num) {
        return (num & 1) == 1;
    }

    private int changeNum(int num) {
        //0 ^ 1 = 1
        //1 ^ 1 = 0
        //同为0，异为1
        return num ^ 1;
    }

    private int changeNum_2(int num) {
        if (num == 1) {
            return 0;
        }
        return 1;
    }
}
