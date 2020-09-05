package org.alphacat.leetcode.solution.classic.string.math;

public class No43_multiply {

    private String ZERO = "0";

    public String multiply(String num1, String num2) {
        if (num1.equals(ZERO) || num2.equals(ZERO)) {
            return ZERO;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; --i) {
            int n1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + ans[i + j + 1];
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (ans[0] != 0) {
            sb.append(ans[0]);
        }
        for (int i = 1; i < l1 + l2; ++i) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public String multiply_2(String num1, String num2) {
        if (num1.equals(ZERO) || num2.equals(ZERO)) {
            return ZERO;
        }
        String ans = ZERO;
        int l_1 = num1.length();
        int l_2 = num2.length();

        StringBuilder sb = new StringBuilder();


        for (int i = l_1 - 1; i >= 0; --i) {
            int carry = 0;
            sb.delete(0, sb.length());

            int n1 = num1.charAt(i) - '0';

            for (int j = l_2 - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }

            while (carry > 0) {
                sb.append(carry % 10);
                carry /= 10;
            }

            sb.reverse();

            for (int j = 0; j < num1.length() - 1 - i; ++j) {
                sb.append(ZERO);
            }
            ans = add(ans, sb.toString());
        }
        return ans;
    }

    private String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int l_1 = s1.length();
        int l_2 = s2.length();
        int p = l_1 - 1;
        int q = l_2 - 1;
        int carry = 0;
        while (p >= 0 && q >= 0) {
            int n1 = s1.charAt(p) - '0';
            int n2 = s2.charAt(q) - '0';
            int sum = (n1 + n2 + carry);
            sb.append(sum % 10);
            carry = sum / 10;
            --p;
            --q;
        }
        while (p >= 0) {
            int n1 = s1.charAt(p) - '0';
            int sum = (n1 + carry);
            sb.append(sum % 10);
            carry = sum / 10;
            --p;
        }
        while (q >= 0) {
            int n2 = s2.charAt(q) - '0';
            int sum = (n2 + carry);
            sb.append(sum % 10);
            carry = sum / 10;
            --q;
        }
        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;
        }
        sb.reverse();
        return sb.toString();
    }
}
