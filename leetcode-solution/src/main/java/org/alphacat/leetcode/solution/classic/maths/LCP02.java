package org.alphacat.leetcode.solution.classic.maths;

public class LCP02 {

    public int[] fraction(int[] cont) {
        int n = cont.length;
        Num fractionNum = new Num(cont[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            Num a_i = new Num(cont[i], 1);
            fractionNum.reverse();
            fractionNum = plus(fractionNum, a_i);
        }
        int[] ans = new int[2];
        ans[0] = fractionNum.molecular;
        ans[1] = fractionNum.denominator;
        return ans;
    }


    private Num plus(Num a, Num b) {
        int lcm = getLCM(a.denominator, b.denominator);
        int molecular = lcm / a.denominator * a.molecular
                + lcm / b.denominator * b.molecular;
        int gcd = getGCD(lcm, molecular);
        return new Num(molecular / gcd, lcm / gcd);
    }

    //最大公约数
    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGCD(b, a % b);
    }

    //最小公倍数
    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    private class Num {
        int molecular;
        int denominator;

        public Num(int _molecular, int _denominator) {
            molecular = _molecular;
            denominator = _denominator;
        }

        public void reverse() {
            int temp = molecular;
            molecular = denominator;
            denominator = temp;
        }
    }
}
