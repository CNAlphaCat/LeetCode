package org.alphacat.leetcode.solution.easy.no1to100;

public class No7 {
	public int reverse(int x) {
        int temp = 0;
        int res = 0;
        while(x!=0){
            temp = x % 10;
            x = x/10;
            if(res > Integer.MAX_VALUE/10 || (res== Integer.MAX_VALUE/10 && temp>7)) return 0;
            if(res < Integer.MIN_VALUE/10 || (res== Integer.MIN_VALUE/10 && temp<-8)) return 0;
            res = res * 10 + temp;
        }
        return res;
    }
}
