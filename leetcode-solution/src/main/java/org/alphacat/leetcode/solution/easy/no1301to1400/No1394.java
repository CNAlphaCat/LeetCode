package org.alphacat.leetcode.solution.easy.no1301to1400;

public class No1394 {

    public int findLucky(int[] arr) {
        int size = 501;
        int[] barrel = new int[size];
        for (int num : arr) {
            barrel[num]++;
        }
        for (int num = size - 1; num >= 1; num--) {
            int count = barrel[num];
            if (count == num) {
                return num;
            }
        }
        return -1;
    }
}
