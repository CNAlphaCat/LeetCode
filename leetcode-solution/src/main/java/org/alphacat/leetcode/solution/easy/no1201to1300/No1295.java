package org.alphacat.leetcode.solution.easy.no1201to1300;

public class No1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int temp : nums) {
            if (isEven(temp)) {
                count++;
            }
        }
        return count;
    }

    //根据题目条件的快速判断
    private boolean isEven(int num) {
        if (num > 9 && num < 100) {
            return true;
        }
        if (num > 999 && num < 10000) {
            return true;
        }
        return false;
    }

    //最常规的方法
    private boolean isEven_2(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return (count & 1) == 0;
    }

    //新手程序员法
    private boolean isEven_3(int num) {
        String s = String.valueOf(num);
        return (s.length() & 1) == 0;
    }

    //运用Math类
    private boolean isEven_4(int num) {
        int res = (int) Math.log10(num);
        return (res + 1) % 2 == 0;
    }
}
