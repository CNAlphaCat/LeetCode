package org.alphacat.leetcode.solution.mid.interview;

public class interview64 {
    public int sumNums(int n) {
        boolean flag = (n >= 1) && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums_2(int n) {
        dataHelper data = new dataHelper(n, n + 1, 0);

        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);
        data = turn(data);

        return data.res >> 1;
    }

    private dataHelper turn(dataHelper data) {
        boolean flag = isOdd(data.a) && (data.res += data.b) > 0;
        data.a >>= 1;
        data.b <<= 1;
        return data;
    }

    private class dataHelper {
        int a;
        int b;
        int res;

        public dataHelper(int _a, int _b, int _res) {
            this.a = _a;
            this.b = _b;
            this.res = _res;
        }
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}
