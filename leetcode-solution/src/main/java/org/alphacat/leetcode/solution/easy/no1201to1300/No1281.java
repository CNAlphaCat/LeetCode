package org.alphacat.leetcode.solution.easy.no1201to1300;

public class No1281 {
    public int subtractProductAndSum(int n) {
        int multiplication = 1;
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            multiplication *= temp;
            sum += temp;
            n /= 10;
        }
        return multiplication - sum;
    }
}
