package org.alphacat.leetcode.solution.todo;

public class No788 {

    class Solution {

        //作者：LeetCode
        //链接：https://leetcode-cn.com/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        //没看懂
        public int rotatedDigits(int N) {
            char[] A = String.valueOf(N).toCharArray();
            int K = A.length;

            int[][][] memo = new int[K+1][2][2];
            memo[K][0][1] = memo[K][1][1] = 1;
            for (int i = K - 1; i >= 0; --i) {
                for (int eqf = 0; eqf <= 1; ++eqf)
                    for (int invf = 0; invf <= 1; ++invf) {
                        // We will compute ans = memo[i][eqf][invf],
                        // the number of good numbers with respect to N = A[i:].
                        // If eqf is true, we must stay below N, otherwise
                        // we can use any digits.
                        // Invf becomes true when we write a 2569, and it
                        // must be true by the end of our writing as all
                        // good numbers have a digit in 2569.
                        int ans = 0;
                        for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
                            if (d == '3' || d == '4' || d == '7') continue;
                            boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                            ans += memo[i+1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                        }
                        memo[i][eqf][invf] = ans;
                    }
            }

            return memo[0][1][0];
        }

    }

    public int rotatedDigits_2(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isGoodNum(int n) {
        boolean isContainGoodDigits = false;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 4 || digit == 3 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isContainGoodDigits = true;
            }
            n /= 10;
        }
        return isContainGoodDigits;
    }
}
